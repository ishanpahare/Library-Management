var BookView = Backbone.View.extend({
    tagName: 'li',
    template: _.template($('#book-details').html()),
    render: function () {
        this.$el.html(this.template(this.model.toJSON()))
        return this;
    }
});

var BookListView = Backbone.View.extend({
    tagName: 'ul',
    initialize: function () {
        this.listenTo(this.collection, 'sync change', this.render);
        this.collection.fetch();
        this.render();
    },

    render: function () {
        this.collection.each(function (book) {
            var bookView = new BookView({model: book});
            console.log(book);
            this.$el.append(bookView.render().el)
        }, this);
        return this;
    }
});

var bookList = new BooksCollection();
var bookListView = new BookListView({collection: bookList})
$(document.body).append(bookListView.render().el);
