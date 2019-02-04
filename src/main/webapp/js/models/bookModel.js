var Book = Backbone.Model.extend({
    defaults: {
        uid: null,
        bookName: "",
        author: "",
        publisher: "",
        isbn: null,
        price: null,
    },
    url: "http://localhost:8080/LMS_war/webapi/books"
});

var BooksCollection = Backbone.Collection.extend({
    model: Book,
    url: "http://localhost:8080/LMS_war/webapi/books"
});