var AppRouter = Backbone.Router.extend({


    routes:{
        "":"list",
        "customers/all":"customerDetails"
    },

    customerDetails: function () {
        var customers = new CustomerCollection();

        $('#content',new CustomerListView({collection:customers}))
    }
});

var app = new AppRouter();
Backbone.history.start();