var GetVendorIdView = Backbone.View.extend({
    template: _.template($('#vendor-form-tmpl').html()),

    events:{
        submit: 'getBook'
    },
    getBook: function(e) {
        e.preventDefault();
        var vid = Number(this.$('input[name="vid"]').val());
        console.log('id that i got from the form'+vid);
        var vendors = new VendorCollection();
        vendors.fetch().then(function(){
            var vendor = vendors.findWhere({vid:vid});
            if(typeof vendor!="undefined"){
                sessionStorage.setItem('Vid',vid.toString());
                location.replace("VendorInventoryById.html");
            }
            else{
                document.getElementById('status').innerHTML = "Vendor with the given Id does not exist!"
            }
        })
    },

    render: function() {
        this.$el.html(this.template);
        return this;
    }
});

/*
var GetVendorTableView = Backbone.View.extend({
    template: _.template($('#vendor-table-tmpl').html()),

    initialize: function(){
        this.listenTo(this.collection, 'sync change', this.render);
        this.render();
    },

    render: function() {
        this.$el.html(this.template);
        return this;
    }
});
*/



var getVendorBookView = new GetVendorIdView();
$(document.body).append(getVendorBookView.render().el);


