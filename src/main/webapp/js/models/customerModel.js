var Customer = Backbone.Model.extend({
    defaults:{
        customerId:null,
        customerName:""
    },
    url:"http://localhost:8080/LMS_war/webapi/customers"
});

var CustomerCollection = Backbone.Collection.extend({
    model:Customer,
    url:"http://localhost:8080/LMS_war/webapi/customers"
});


