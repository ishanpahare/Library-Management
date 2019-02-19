var GetVendorIdView = Backbone.View.extend({
    template: _.template($('#vendor-form-tmpl').html()),

    events:{
        submit: 'getBook'
    },
    getBook: function(e) {
        e.preventDefault();
        var vid = Number(this.$('input[name="vid"]').val());
        console.log('id that i got from the form'+vid);
        sessionStorage.setItem('Vid',vid.toString());
    },

    render: function() {
        this.$el.html(this.template);
        return this;
    }
});

var GetVendorTableView = Backbone.View.extend({
    template: _.template($('#vendor-table-tmpl').html()),

    render: function() {
        this.$el.html(this.template);
        return this;
    }
});

var VendorBookByIdView = Backbone.View.extend({
    tagName: 'tr',
    template: _.template($('#vendor-book-tmpl').html()),
    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});

var VendorBookByIdListView = Backbone.View.extend({
    el:'tbody',
    initialize: function () {
        console.log("collection view initialized!");
        this.listenTo(this.collection, 'sync change', this.render);
        this.collection.fetch();
        this.render();
    },

    render: function () {
        this.collection.each(function (vendorBook) {
            var vendorBookByIdView = new VendorBookByIdView({model: vendorBook});
            console.log(vendorBook);
            this.$el.append(vendorBookByIdView.render().el)
        }, this);
        return this;
    }
});

var getVendorBookView = new GetVendorIdView();
$(document.body).append(getVendorBookView.render().el);

var getVendorTableView = new GetVendorTableView();
$(document.body).append(getVendorTableView.render().el);

var vid = sessionStorage.getItem('Vid');
var vendorBookList = new VendorBookWithVendorCollection([], {id: vid});
var vendorBookByIdListView = new VendorBookByIdListView({collection: vendorBookList});
$(document.getElementById("vendor-book-table")).append(vendorBookByIdListView.render().el);
