var CustomerLoginView = Backbone.View.extend({
    template: _.template($('#customer-login-tmpl').html()),

    events: {
        submit: 'login'
    },

    login: function (e) {
        e.preventDefault();
        var cid =Number(this.$('input[name = "cid"]').val());
        var email = this.$('input[name = "customerEmail"]').val();
        var dob = this.$('input[name = "customerDOB"]').val();
        var customers = new CustomerCollection();
        customers.fetch().then(function(){
            var customer = customers.findWhere({'cid':cid});
            if((typeof customer != "undefined") && (customer.get('email') == email) && (customer.get('dob') == dob)){
            var customer_name = customer.get('name');
                sessionStorage.setItem('username',customer_name);
                sessionStorage.setItem('id',cid.toString());
                var session_username = sessionStorage.getItem('username');
                location.replace("CustomerView.html");
            }
            else{
                document.getElementById('status').innerHTML = "Invalid credentials! Try again."
            }
        });
    },

    render: function() {
        this.$el.html(this.template);
        return this;
    }
});

/*var librarians = new LibrarianCollection();*/
var customerLoginView = new CustomerLoginView();
$(document.body).append(customerLoginView.render().el);