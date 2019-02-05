var ReturnBook = Backbone.Model.extend({
    defaults: {
        uid:null,
        cid:null,
        lid:null
    },
    url: "http://localhost:8080/LMS_war/webapi/issuedBooks/return"
});

var ReturnBooksCollection = Backbone.Collection.extend({
    model: IssuedBook,
    url: "http://localhost:8080/LMS_war/webapi/issuedBooks/return"
});