var Vendor = Backbone.Model.extend({
    defaults:{
        vid:null,
        name:""
    },
    url:"http://localhost:8080/LMS_war/webapi/vendors"
});

var VendorCollection = Backbone.Collection.extend({
    model:Vendor,
    url:"http://localhost:8080/LMS_war/webapi/vendors"
});