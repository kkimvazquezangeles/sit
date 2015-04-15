define([
	'jquery',
    'underscore',
	'core/BaseView',
	'text!templates/tplSitNav.html',
	'Session'
], function($, _, BaseView, tplSitNav, Session){

	var SitNavView = BaseView.extend({
	    el: $("#sit-nav"),

        template: _.template(tplSitNav),

        events: {

            'click #asignaciones': 'verAsignaciones',
            'click #tutores' : 'verTutores',
            'click #plan-dir': 'verPlanesDir',
            'click #seguimiento-dir': 'verSeguimientosDir',

            'click #canalizar': 'verCanalizar',
            'click #seguimiento-prof': 'verSeguimientoProf',

            'click #plan': 'verPlan',
            'click #seguimiento-psi': 'verSeguimientosPsi',

            'click #plantuto': 'verTutoria',
            'click #bitacora': 'verBitacora',
            'click #profesores': 'verProfesores',
            'click #seguimiento': 'verSeguimientos',

            'click #salir': 'salir'
        },

        initialize: function() {
            this.render();
            this.configNav();
        },

        render: function() {
            this.$el.html(this.template());
            return this;
        },

        configNav: function(){
            $("nav li").hide();
            $("#salir").show();

            if (Session.getRole() == 'DIRECTOR'){
                $("#asignaciones").show();
                $("#tutores").show();
                $("#plan-dir").show();
                $("#seguimiento-dir").show();
                return;
            }

            if (Session.getRole() == 'PROFESOR'){
                $("#canalizar").show();
                $("#seguimiento-prof").show();
                return;
            }

            if (Session.getRole() == 'PSICOLOGO'){
                $("#plan").show();
                $("#seguimiento-psi").show();
                return;
            }

            if (Session.getRole() == 'TUTOR'){
                $("#plantuto").show();
                $("#bitacora").show();
                $("#profesores").show();
                $("#seguimiento").show();
            }
        },

        verAsignaciones: function(){
            Backbone.history.navigate('director/asignaciones', { trigger : true });
        },

        verTutores: function(){
            Backbone.history.navigate('director/tutores', { trigger : true });
        },

        verPlanesDir: function(){
            Backbone.history.navigate('director/plan', { trigger : true });
        },

        verSeguimientosDir: function(){
            Backbone.history.navigate('director/seguimiento', { trigger : true });
        },

        verCanalizar: function(){
            Backbone.history.navigate('profesor/canalizar', { trigger : true });
        },

        verSeguimientoProf: function(){
            Backbone.history.navigate('profesor/seguimiento', { trigger : true });
        },

        verPlan: function(){
            Backbone.history.navigate('psicologo/plan', { trigger : true });
        },

        verSeguimientosPsi: function(){
            Backbone.history.navigate('psicologo/seguimiento', { trigger : true });
        },

        verTutoria: function(){
            Backbone.history.navigate('tutor/plan', { trigger : true });
        },

        verBitacora: function(){
            Backbone.history.navigate('tutor/bitacora', { trigger : true });
        },

        verProfesores: function(){
            Backbone.history.navigate('tutor/profesores', { trigger : true });
        },

        verSeguimientos: function(){
            Backbone.history.navigate('tutor/seguimiento', { trigger : true });
        },

        closeHotelDetail: function(){
            Backbone.history.navigate('', {trigger: true});
            $("#close-hotel-detail").hide();
        }
	});

	return SitNavView;

});