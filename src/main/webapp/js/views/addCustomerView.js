var AddCustomerView = Backbone.View.extend({
    template: _.template($('#add-customer-tmpl').html()),

    events:{
        submit: 'save'
    },
    save: function(e) {
        e.preventDefault();
        var name = this.$('input[name="customerName"]').val();
        var email = this.$('input[name="customerEmail"]').val();
        var dob = this.$('input[name="customerDOB"]').val();
        var doj = new Date().toDateString()
        console.log("the name is: "+name);
        this.model.save({name:name,email:email,dob:dob,doj:doj}, {
            success: function(model, response, options) {
                console.log('Save successful');
                document.getElementById('status').innerHTML = "Customer added successfully!"
            },
            error: function(model, xhr, options) {
                console.log('Save error');
                document.getElementById('status').innerHTML = "Error adding customer. Try again."
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
