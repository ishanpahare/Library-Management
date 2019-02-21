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

var vid = sessionStorage.getItem('Vid');
var vendorBookList = new VendorBookWithVendorCollection([], {id: vid});

var vendorBookByIdListView = new VendorBookByIdListView({collection: vendorBookList});
$(document.getElementById("vendor-book-table")).append(vendorBookByIdListView.render().el);