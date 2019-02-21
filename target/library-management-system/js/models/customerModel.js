var Customer = Backbone.Model.extend({
    defaults:{
        cid:null,
        name:"",
        issuedBooks:[],
        email:"",
        dob:"",
        doj:""
    },
    url:"http://localhost:8080/LMS_war/webapi/customers"
});

var CustomerCollection = Backbone.Collection.extend({
    model:Customer,
    url:"http://localhost:8080/LMS_war/webapi/customers"
});

var CustomerById = Backbone.Model.extend({
    defaults:{
        cid:null,
        name:"",
        email:"",
        dob:"",
        doj:""
    },

    initialize:function(models,options){
        this.cid=options.id;
    },

    url: function () {
        return 'http://localhost:8080/LMS_war/webapi/customers/'+this.cid;
    },
});


