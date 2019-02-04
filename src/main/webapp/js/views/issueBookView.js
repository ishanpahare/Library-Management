var AddBookView = Backbone.View.extend({
    template: _.template($('#issue-book-tmpl').html()),

    events:{
        submit: 'issue'
    },
    issue: function(e) {
        e.preventDefault();
        var uid = this.$('input[name="bookUid"]').val();
        var cid = this.$('input[name="customerId"]').val();
        this.model.save({bookName: bookName,author:author,publisher:publisher,isbn:isbn,price:price}, {
            success: function(model, response, options) {
                console.log('Save successful');
                alert('Book Added Successfully!')
            },
            error: function(model, xhr, options) {
                console.log('Save error');
            }
        });
    },
    render: function() {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
});

var book = new Book();
var addBookView = new AddBookView({model:book})
$(document.body).append(addBookView.render().el);