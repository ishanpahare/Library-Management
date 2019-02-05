var IssueBookView = Backbone.View.extend({
    template: _.template($('#issue-book-tmpl').html()),

    events:{
        submit: 'issue'
    },
    issue: function(e) {
        e.preventDefault();
        var uid = Number(this.$('input[name="uid"]').val());
        var cid = Number(this.$('input[name="cid"]').val());
        var lid = Number(this.$('input[name="lid"]').val());
        this.model.save({uid: uid,cid:cid,lid:lid}, {
            success: function(model, response, options) {
                console.log('Issue successful');
                alert('Book Issued Successfully!')
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

var issuedBook = new IssuedBook();
var issueBookView = new IssueBookView({model:issuedBook})
$(document.body).append(issueBookView.render().el);