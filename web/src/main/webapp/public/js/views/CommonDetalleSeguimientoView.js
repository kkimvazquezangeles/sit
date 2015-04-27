define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplCommonDetalleSeguimiento.html',
	'Session'
], function($, _, BaseView, tplCommonDetalleSeguimiento, Session){

	var CommonDetalleSeguimientoView = BaseView.extend({
	    el: '#detalle-seguimiento',

        template: _.template(tplCommonDetalleSeguimiento),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            this.configure()
        },

        configure: function(){
            $('#tpo-tutoria option[value="'+this.model.get('tipoTutoria')+'"]').attr('selected', 'selected');
            $('#estatus option[value="'+this.model.get('statusTutoria')+'"]').attr('selected', 'selected');
            $('#depto option[value="'+this.model.get('departamento')+'"]').attr('selected', 'selected');

            switch(Session.getRole()){
                case 'DIRECTOR':
                    this.configureDir();
                break;
                case 'TUTOR':
                    this.configureTut();
                break;
                case 'PROFESOR':
                    this.configureProf();
                break;
                case 'PSICOLOGO':
                    this.configurePsic();
                break;

            }
        },

        configureDir: function(){
            $("#depto option[value='TUTOR']").attr('disabled','disabled');
            $("#depto option[value='DIRECCION']").attr('disabled','disabled');
            $("#tpo-tutoria").attr('disabled','disabled');
            $("#estatus").attr('disabled','disabled');
            $("#btnRedactar").hide();
            $("#btnBitacora").hide();
        },

        configureTut: function(){
            $("#depto option[value='TUTOR']").attr('disabled','disabled');
            $("#depto option[value='PSICOLOGIA']").attr('disabled','disabled');
            $("#btnRedactar").hide();
        },

        configurePsic: function(){
            $("#estatus option[value='REGISTRADA']").attr('disabled','disabled');
            $("#tpo-tutoria").attr('disabled','disabled');
            $("#canalizar").hide();
            $("#depto").hide();
            $("#btnGuardar").hide();
            $("#btnBitacora").hide();

        },

        configureProf: function(){
            $("#depto").attr('disabled','disabled');
            $("#tpo-tutoria").attr('disabled','disabled');
            $("#estatus").attr('disabled','disabled');
            $("#depto").hide();
            $("#btnGuardar").hide();
            $("#btnBitacora").hide();
            $("#btnRedactar").hide();

        }
	});

	return CommonDetalleSeguimientoView;

});