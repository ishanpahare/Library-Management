var OrderBook = Backbone.Model.extend({
    defaults:{
        id:null,
        isbn:null,
        quantity:null
    },

    url:'http://localhost:8080/LMS_war/webapi/vendorBooks/order/'
});