define([
	'jquery',
	'core/BaseView',
	'text!templates/tplSitNav.html',
	'Session'
], function($, BaseView, tplSitNav, Session){

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

        },

        verPlanesDir: function(){

        },

        verSeguimientosDir: function(){

        },

        verCanalizar: function(){

        },

        verSeguimientoProf: function(){

        },

        verTutoria: function(){

        },

        verBitacora: function(){

        },

        verProfesores: function(){

        },

        verSeguimientos: function(){

        },

        closeHotelDetail: function(){
            Backbone.history.navigate('', {trigger: true});
            $("#close-hotel-detail").hide();
        }
	});

	return SitNavView;

});