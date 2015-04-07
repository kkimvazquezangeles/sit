define([
	'jquery',
	'underscore',
	'backbone',
	'core/BaseRouter',
	'views/HotelAdnView',
	'views/HotelDetailView'
], function($, _, Backbone, BaseRouter, HotelAdnView, HotelDetailView){
        var Router = BaseRouter.extend({

        routes: {
            '': 'hotel',
            'hotel/:id/detail': 'detalle'
        },

        before : function(params, next){
            console.log('before');
            return next();
        },

        after : function(){
            console.log('after');
        },

        changeView : function(view){
            //Close is a method in BaseView
            //that check for childViews and
            //close them before closing the
            //parentView
            function setView(view){
                if(this.currentView){
                    this.currentView.close();
                }
                this.currentView = view;
                $('.container').html(view.render().$el);
            }

            setView(view);
        },

        initialize: function () {
            this.hotel();
        },

        hotel: function(){
            var view = new HotelAdnView();
            this.changeView(view);
        },

        detalle: function(id){
            var modelo = app.hoteles.get(id);
            var view = new HotelDetailView({model: modelo});
            this.changeView(view);
        }
	});

	return Router;

});
