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
            'click #seg-btn-bitacora' : 'generaPdf'
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            this.configure()
        },

        configure: function(){
            $('#seg-tipo-tutoria option[value="'+this.model.get('tipoTutoria')+'"]').attr('selected', 'selected');
            $('#seg-status option[value="'+this.model.get('statusTutoria')+'"]').attr('selected', 'selected');
            $('#seg-depto option[value="'+this.model.get('departamento')+'"]').attr('selected', 'selected');

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
            $("#seg-depto option[value='TUTOR']").attr('disabled','disabled');
            $("#seg-depto option[value='DIRECCION']").attr('disabled','disabled');
            $("#seg-tipo-tutoria").attr('disabled','disabled');
            $("#seg-status").attr('disabled','disabled');
            $("#seg-btn-redactar").hide();
            $("#seg-btn-bitacora").hide();
        },

        configureTut: function(){
            $("#seg-status option[value='REGISTRADA']").attr('disabled','disabled');
            $("#seg-depto option[value='TUTOR']").attr('disabled','disabled');
            $("#seg-depto option[value='PSICOLOGIA']").attr('disabled','disabled');
            $("#seg-btn-redactar").hide();
        },

        configurePsic: function(){
            $("#seg-status option[value='REGISTRADA']").attr('disabled','disabled');
            $("#seg-tipo-tutoria").attr('disabled','disabled');
            $("#seg-lb-depto").hide();
            $("#seg-depto").hide();
            $("#seg-btn-guardar").hide();
            $("#seg-btn-bitacora").hide();

        },

        configureProf: function(){
            $("#seg-depto").attr('disabled','disabled');
            $("#seg-tipo-tutoria").attr('disabled','disabled');
            $("#seg-status").attr('disabled','disabled');
            $("#seg-lb-depto").hide();
            $("#seg-depto").hide();
            $("#seg-btn-guardar").hide();
            $("#seg-btn-bitacora").hide();
            $("#seg-btn-redactar").hide();

        },

        generaPdf: function(){
            var url = "report/bitacoraAlumno?periodo=" + Session.get('idPeriodo') + "&matricula=" + this.model.get('matricula');
            window.open(url, '_blank');
        }
	});

	return CommonDetalleSeguimientoView;

});