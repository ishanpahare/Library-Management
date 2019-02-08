var VendorIdView = Backbone.View.extend({
    template: _.template($('#vendor-form-tmpl').html()),

    events: {
        submit: 'getBooks'
    },

    getBooks: function (e) {
        e.preventDefault();
        var vid =Number(this.$('input[name = "vid"]').val());

    }
});