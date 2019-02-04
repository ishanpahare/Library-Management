var AppRouter = Backbone.Router.extend({


    routes:{
        "":"list",
        "customers/all":"customerDetails"
    },

    customerDetails: function () {
        var customers = new CustomerCollection();
        var customerView = new CustomerListView({collection:customers});
        $('#content').html(new CustomerView.render().el);
    }
});

var app = new AppRouter();
Backbone.history.start();