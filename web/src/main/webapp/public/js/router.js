define([
	'jquery',
	'underscore',
	'backbone',
	'core/BaseRouter',
	'views/SitNavView',
	'views/DirAsignacionesView',
	'views/DirTutoresView',
	'views/DirPlanView',
	'views/DirSeguimientoView',
	'views/ProfCanalizarView',
	'views/ProfSeguimientoView',
	'views/PsicPlanView',
	'views/PsicSeguimientoView',
	'views/TutPlanView',
	'views/TutBitacoraView',
	'views/TutProfesoresView',
	'views/TutSeguimientoView',
    'Session'
], function($, _, Backbone, BaseRouter, SitNavView, DirAsignacionesView, DirTutoresView, DirPlanView, DirSeguimientoView,
            ProfCanalizarView, ProfSeguimientoView, PsicPlanView, PsicSeguimientoView,
            TutPlanView, TutBitacoraView, TutProfesoresView, TutSeguimientoView, Session){
        var Router = BaseRouter.extend({

        routes: {
            'prosefor'              : 'prosefor',
            'director'              : 'director',
            'tutor'                 : 'tutor',
            'psicologo'             : 'psicologo',
            'director/asignaciones' : 'directorAsignaciones',
            'director/tutores'      : 'tutores',
            'director/plan'         : 'dirPlan',
            'director/seguimiento'  : 'dirSeguimiento',
            'profesor/canalizar'    : 'profCanalizar',
            'profesor/seguimiento'  : 'profSeguimiento',
            'psicologo/plan'        : 'psicPlan',
            'psicologo/seguimiento' : 'psicSeguimiento',
            'tutor/plan'            : 'tutorPlan',
            'tutor/bitacora'        : 'tutorBitacora',
            'tutor/profesores'      : 'tutorProfesores',
            'tutor/seguimiento'     : 'tutorSeguimiento'
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

        tutores: function(){
            var view = new DirTutoresView();
            this.changeView(view);
        },

        dirPlan: function(){
            var view = new DirPlanView();
            this.changeView(view);
        },

        dirSeguimiento: function(){
            var view = new DirSeguimientoView();
            this.changeView(view);
         },

        profCanalizar: function(){
            var view = new ProfCanalizarView();
            this.changeView(view);
        },

        profSeguimiento: function(){
             var view = new ProfSeguimientoView();
             this.changeView(view);
        },

        psicPlan: function(){
              var view = new PsicPlanView();
              this.changeView(view);
        },

        psicSeguimiento: function(){
              var view = new PsicSeguimientoView();
              this.changeView(view);
        },

        tutorPlan: function(){
              var view = new TutPlanView();
              this.changeView(view);
        },

        tutorBitacora: function(){
              var view = new TutBitacoraView();
              this.changeView(view);
        },

        tutorProfesores: function(){
              var view = new TutProfesoresView();
              this.changeView(view);
        },

        tutorSeguimiento: function(){
              var view = new TutSeguimientoView();
              this.changeView(view);
        }
	});

	return Router;

});
