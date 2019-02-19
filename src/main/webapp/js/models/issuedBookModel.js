var IssuedBook = Backbone.Model.extend({
    defaults: {
        uid: null,
        cid: null,
        lid: null
    },
    url: "http://localhost:8080/LMS_war/webapi/issuedBooks"
});

var IssuedBooksCollection = Backbone.Collection.extend({
    model: IssuedBook,
    url: "http://localhost:8080/LMS_war/webapi/issuedBooks"
});

var IssuedBookCustomer = Backbone.Model.extend({
    defaults: {
        uid: null,
        name: "",
        author: "",
        publisher: "",
        isbn: null,
        price:null,
        cid:null,
        issueDate:"",
        returnDate:""
    },
});

var IssuedCustomerCollection = Backbone.Collection.extend({
    initialize:function(models,options){
        this.cid=options.id;
    },
    url: function () {
        return 'http://localhost:8080/LMS_war/webapi/issuedBooks/customers/'+this.cid;
    },
    model: IssuedBookCustomer
});

var AllIssuedBook = Backbone.Model.extend({
    defaults: {
        uid: null,
        name: "",
        author: "",
        publisher: "",
        isbn: null,
        price:null,
        cid:null,
        issueDate:"",
        returnDate:""
    },
})

var AllIssuedBookCollection = Backbone.Collection.extend({
    url: function () {
            return 'http://localhost:8080/LMS_war/webapi/issuedBooks/';
    },
    model: AllIssuedBook
})


