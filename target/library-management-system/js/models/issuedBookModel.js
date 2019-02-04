var IssuedBook = Backbone.Model.extend({
    defaults: {
        uid: null,
        bookName: "",
        author: "",
        publisher: "",
        isbn: null,
        price: null,
        issueDate:"",
        returnDate:""
    },
    url: "http://localhost:8080/LMS_war/webapi/issuedBooks"
});

var IssuedBooksCollection = Backbone.Collection.extend({
    model: IssuedBook,
    url: "http://localhost:8080/LMS_war/webapi/issuedBooks"
});