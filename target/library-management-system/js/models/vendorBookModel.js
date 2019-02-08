var VendorBook = Backbone.Model.extend({
    defaults:{
        uid:null,
        name:"",
        isbn:null,
        price:null,
        author:"",
        publisher:"",
        vid:null
    },
    url:"http://localhost:8080/LMS_war/webapi/vendorBooks"
});

var VendorBookCollection = Backbone.Collection.extend({
    model:VendorBook,
    url:"http://localhost:8080/LMS_war/webapi/vendorBooks"
});