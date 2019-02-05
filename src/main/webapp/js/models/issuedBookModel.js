var IssuedBook = Backbone.Model.extend({
    defaults: {
       uid:null,
        cid:null,
        lid:null
    },
    url: "http://localhost:8080/LMS_war/webapi/issuedBooks"
});

var IssuedBooksCollection = Backbone.Collection.extend({
    model: IssuedBook,
    url: "http://localhost:8080/LMS_war/webapi/issuedBooks"
});
