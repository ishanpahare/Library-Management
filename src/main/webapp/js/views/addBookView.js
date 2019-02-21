var AddBookView = Backbone.View.extend({
    template: _.template($('#add-book-tmpl').html()),

    events:{
        submit: 'save'
    },
    save: function(e) {
        e.preventDefault();
        var bookName = this.$('input[name="bookName"]').val();
        var author = this.$('input[name="author"]').val();
        var publisher = this.$('input[name="publisher"]').val();
        var isbn = Number(this.$('input[name="isbn"]').val());
        var price = Number(this.$('input[name="price"]').val());
        this.model.save({bookName: bookName,author:author,publisher:publisher,isbn:isbn,price:price}, {
            success: function(model, response, options) {
                console.log('Save successful');
                document.getElementById('status').innerHTML = "Book added successfully!"
            },
            error: function(model, xhr, options) {
                console.log('Save error');
                document.getElementById('status').innerHTML = "Book could not be added. Try again."
            }
        });
    },
    render: function() {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
});

var book = new Book();
var addBookView = new AddBookView({model:book});
$(document.body).append(addBookView.render().el);
