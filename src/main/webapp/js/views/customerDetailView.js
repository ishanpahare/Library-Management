var CustomerDetailView = Backbone.View.extend({
    template: _.template($('#customer-info-tmpl').html()),
    render: function () {
        this.$el.html(this.template(this.model.toJSON()))
        return this;
    }
})

var cid = Number(sessionStorage.getItem('id'));
var customers = new CustomerCollection();
customers.fetch().then(function () {
    var customer = customers.findWhere({'cid':cid})

    var customerDetailsView = new CustomerDetailView({model:customer});
    $(document.body).append(customerDetailsView.render().el);
})