var GetVendorIdView = Backbone.View.extend({
    template: _.template($('#vendor-form-tmpl').html()),

    events:{
        submit: 'getBook'
    },
    getBook: function(e) {
        e.preventDefault();
        var vid = Number(this.$('input[name="vid"]').val());
        console.log('id that i got from the form'+vid);
        var vendorBookList = new VendorBookWithVendorCollection([], {id: vid});
        var vendorBookByIdListView = new VendorBookByIdListView({collection: vendorBookList});
        $(document.getElementById("book-list")).append(vendorBookByIdListView.render().el);
    },

    render: function() {
        this.$el.html(this.template);
        return this;
    }
});

var VendorBookByIdView = Backbone.View.extend({
    tagName: 'li',
    template: _.template($('#vendor-book-tmpl').html()),
    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});

var VendorBookByIdListView = Backbone.View.extend({
    tagName: 'ul',
    initialize: function () {
        console.log("collection view initialized!");
        this.listenTo(this.collection, 'sync change', this.render);
        this.collection.fetch();
        this.render();
    },

    render: function () {
        this.collection.each(function (vendorBook) {
            console.log('inside the loop of collections');
            var vendorBookByIdView = new VendorBookByIdView({model: vendorBook});
            console.log(vendorBook);
            this.$el.append(vendorBookByIdView.render().el)
        }, this);
        return this;
    }
});

var getVendorBookView = new GetVendorIdView();
$(document.getElementById("vendor-form")).append(getVendorBookView.render().el);

