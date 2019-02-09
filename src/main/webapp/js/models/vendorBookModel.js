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

var VendorBookWithVendor = Backbone.Model.extend({
    defaults: {
        uid: null,
        name: "",
        author: "",
        publisher: "",
        isbn: null,
        price:null,
        cid:null
    },
});

var VendorBookWithVendorCollection = Backbone.Collection.extend({
    initialize:function(models,options){
        this.cid=options.id;
    },
    url: function () {
        return 'http://localhost:8080/LMS_war/webapi/vendorBooks/vendor/'+this.cid;
    },
    model: VendorBookWithVendor
});
