var ReturnBookView = Backbone.View.extend({
    template: _.template($('#return-book-tmpl').html()),

    events: {
        submit: 'return'
    },
    return: function (e) {
        e.preventDefault();
        var uid = Number(this.$('input[name="uid"]').val());
        var cid = Number(this.$('input[name="cid"]').val());
        var lid = Number(this.$('input[name="lid"]').val());
        this.model.save({uid: uid, cid: cid, lid: lid}, {
            success: function (model, response, options) {
                console.log('Return successful');
                document.getElementById('status').innerHTML = "Book returned successfully!"
            },
            error: function (model, xhr, options) {
                console.log('Return error');
                document.getElementById('status').innerHTML = "Books is either not issued or not in stock. Try again."

            }
        });
    },
    render: function () {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
});

var returnBook = new ReturnBook();
var returnBookView = new ReturnBookView({model: returnBook});
$(document.body).append(returnBookView.render().el);