var cid = Number(sessionStorage.getItem('id'));
var SingleCustomerView = Backbone.View.extend({
    template: _.template($('#customer-detail-tmpl').html()),
    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});

var AllCustomerListView = Backbone.View.extend({
    tagName:'ul',
    initialize: function () {
        console.log("collection view initialized!");
        this.listenTo(this.collection, 'sync change', this.render);
        this.collection.fetch();
        this.render();
    },

    render: function () {
        this.collection.each(function (issuedBook) {
            console.log('inside the loop of collections');
            if(issuedBook.get("cid") == cid) {
                var customerView = new SingleCustomerView({model: issuedBook});
                console.log(issuedBook);
                this.$el.append(customerView.render().el)
            }
        }, this);
        return this;
    }
});

var customerDetail = new CustomerCollection();
var customerDetailView = new AllCustomerListView({collection:customerDetail});
$(document.getElementById("customer-detail-box")).append(customerDetailView.render().el);