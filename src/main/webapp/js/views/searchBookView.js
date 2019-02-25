var SearchCustomerView = Backbone.View.extend({
    template: _.template($('#search-customer-view').html()),

    events:{
        submit: 'search'
    },
    save: function(e) {
        e.preventDefault();
        var bookName = this.$('input[name="bookName"]').val();

        this.model.save({name:name,email:email,dob:dob,doj:doj}, {
            success: function(model, response, options) {
                console.log('Save successful');
                document.getElementById("status").innerHTML = "Customer added successfully";
            },
            error: function(model, xhr, options) {
                console.log('Save error');
                document.getElementById("status").innerHTML = "Could not add customer. Try again."
            }
        });
    },
    render: function() {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
});