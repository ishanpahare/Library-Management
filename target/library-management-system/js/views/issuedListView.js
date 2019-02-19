var AllIssuedView = Backbone.View.extend({
    tagName: 'tr',
    template: _.template($('#issued-books-details-tmpl').html()),
    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});

var AllIssuedListView = Backbone.View.extend({
    el:'tbody',
    initialize: function () {
        console.log("collection view initialized!");
        this.listenTo(this.collection, 'sync change', this.render);
        this.collection.fetch();
        this.render();
    },

    render: function () {
        this.collection.each(function (issuedBook) {
            console.log('inside the loop of collections');
            var issuedView = new AllIssuedView({model: issuedBook});
            console.log(issuedBook);
            this.$el.append(issuedView.render().el)
        }, this);
        return this;
    }
});

var allIssuedList = new AllIssuedBookCollection();
var allIssuedListView = new AllIssuedListView({collection:allIssuedList});
$(document.getElementById("all-issued-table")).append(allIssuedListView.render().el);