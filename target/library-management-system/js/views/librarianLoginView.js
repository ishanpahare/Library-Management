var LibrarianLoginView = Backbone.View.extend({
    template: _.template($('#librarian-login-tmpl').html()),

    events: {
        submit: 'login'
    },

    login: function (e) {
        e.preventDefault();
        var username = this.$('input[name ="username"]').val();
        var password = this.$('input[name ="password"]').val();
        var lid =Number(this.$('input[name = "lid"]').val());
        var librarians = new LibrarianCollection();
        librarians.fetch().then(function(){
            var librarian = librarians.findWhere({'lid':lid});
            var librarian_username = librarian.get('username');
            var librarian_password = librarian.get('password');
            if((username === librarian_username) && (password === librarian_password)){
                sessionStorage.setItem('username',librarian_username);
                var session_username = sessionStorage.getItem('username');
                console.log("username for the session is: "+session_username);
                alert('Correct Credentials');
                location.replace("LibrarianView.html");
            }
            else{
                alert('Invalid Credentials')
            }
        });
    },

    render: function() {
        this.$el.html(this.template);
        return this;
    }
});

/*var librarians = new LibrarianCollection();*/
var librarianLoginView = new LibrarianLoginView();
$(document.body).append(librarianLoginView.render().el);