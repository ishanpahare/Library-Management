var AddCustomerView = Backbone.View.extend({
    template: _.template($('#add-customer-tmpl').html()),

    events:{
        submit: 'save'
    },
    save: function(e) {
        e.preventDefault();
        var name = this.$('input[name="customerName"]').val();
        console.log("the name is: "+name);
        this.model.save({name:name}, {
            success: function(model, response, options) {
                console.log('Save successful');
                alert('Customer Added Successfully!')
            },
            error: function(model, xhr, options) {
                console.log('Save error');
            }
        });
    },
    render: function() {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
});

var customer = new Customer();
var addCustomerView = new AddCustomerView({model:customer});
$(document.body).append(addCustomerView.render().el);
