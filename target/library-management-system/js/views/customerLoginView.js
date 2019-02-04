var CustomerLoginView = Backbone.View.extend({
    template: _.template($('#customer-login-tmpl').html()),

    events: {
        submit: 'login'
    },

    login: function (e) {
        e.preventDefault();
        var cid =Number(this.$('input[name = "cid"]').val());
        var customers = new CustomerCollection();
        customers.fetch().then(function(){
            var customer = customers.findWhere({'cid':cid});
            if(typeof customer != "undefined"){
            var customer_name = customer.get('name');
                sessionStorage.setItem('username',customer_name);
                sessionStorage.setItem('id',cid.toString());
                var session_username = sessionStorage.getItem('username');
                console.log("username for the session is: "+session_username);
                alert('Correct Credentials');
                location.replace("CustomerView.html");
            }
            else{
                alert('Invalid Credentials')
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