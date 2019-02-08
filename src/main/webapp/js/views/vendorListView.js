var VendorView = Backbone.View.extend({
    tagName:'li',
    template: _.template($('#vendor-info-tmpl').html()),
    render: function () {
        this.$el.html(this.template(this.model.toJSON()))
        return this;
    }
});

var VendorListView = Backbone.View.extend({
    tagName: 'ul',
    initialize: function () {
        this.listenTo(this.collection, 'sync change', this.render);
        this.collection.fetch();
        this.render();
    },

    render: function () {
        this.collection.each(function (vendor) {
            var bookView = new VendorView({model: vendor});
            console.log(vendor);
            this.$el.append(bookView.render().el)
        }, this);
        return this;
    }
});

var vendorList = new VendorCollection();
var vendorListView = new VendorListView({collection: vendorList})
$(document.body).append(vendorListView.render().el);