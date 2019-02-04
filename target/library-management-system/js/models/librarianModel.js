var Librarian = Backbone.Model.extend({
    defaults:{
        lid:null,
        username:"",
        password:""
    },
     url:"http://localhost:8080/LMS_war/webapi/librarians"
});

var LibrarianCollection = Backbone.Collection.extend({
    model:Librarian,
    url:"http://localhost:8080/LMS_war/webapi/librarians"
});