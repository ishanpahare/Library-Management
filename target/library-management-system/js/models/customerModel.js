var Customer = Backbone.Model.extend({
    defaults:{
        cid:null,
        name:"",
        issuedBooks:[]
    },
    url:"http://localhost:8080/LMS_war/webapi/customers"
});

var CustomerCollection = Backbone.Collection.extend({
    model:Customer,
    url:"http://localhost:8080/LMS_war/webapi/customers"
});


