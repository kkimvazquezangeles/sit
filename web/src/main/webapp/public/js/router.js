define([
	'jquery',
	'underscore',
	'backbone',
	'core/BaseRouter',
	'views/SitNavView',
	'views/DirAsignacionesView',
    'Session'
], function($, _, Backbone, BaseRouter, SitNavView, DirAsignacionesView, Session){
        var Router = BaseRouter.extend({

        routes: {
            'prosefor'              : 'prosefor',
            'director'              : 'director',
            'tutor'                 : 'tutor',
            'psicologo'             : 'psicologo',
            'director/asignaciones' : 'directorAsignaciones'
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
                $('section.container').html(view.render().$el);
            }

            setView(view);
        },

        initialize: function () {
            this.sitNav();
            Backbone.history.navigate(Session.getRole().toLowerCase(), { trigger : true });
        },

        sitNav: function(){
            new SitNavView();
        },

        prosefor: function(){
        },

        director: function(){
        },

        directorAsignaciones: function(){
            var view = new DirAsignacionesView();
            this.changeView(view);
        },

        tutor: function(){
        },

        psicologo: function(){
        }
	});

	return Router;

});
