define([
	'jquery',
	'underscore',
	'core/BaseView',
	'models/TutoriaModel',
	'text!templates/tplCommonDetalleSeguimiento.html',
	'Session'
], function($, _, BaseView, TutoriaModel, tplCommonDetalleSeguimiento, Session){

	var CommonDetalleSeguimientoView = BaseView.extend({
	    el: '#detalle-seguimiento',

        template: _.template(tplCommonDetalleSeguimiento),

        events: {
            'click #seg-btn-bitacora' : 'generaPdf',
            'click #tut-seg-btn-guardar' : 'actualizaTutoria',
            'click #psic-seg-btn-guardar' : 'actualizaEstatus',
            'click #dir-seg-btn-guardar' : 'actualizaDepto'
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
            $("#seg-diagnostico").attr('disabled','disabled');
            $("#seg-proposito").attr('disabled','disabled');
            $("#seg-medidas").attr('disabled','disabled');
            $("#seg-recomendaciones").attr('disabled','disabled');
            $("#seg-btn-redactar").hide();
            $("#seg-btn-bitacora").hide();
            $("#psic-seg-btn-guardar").hide();
            $("#tut-seg-btn-guardar").hide();
        },

        configureTut: function(){
            if($("#seg-depto").val() == 'PSICOLOGIA'){
                $("#seg-depto option[value='DIRECCION']").attr('disabled','disabled');
            }
            $("#seg-status option[value='REGISTRADA']").attr('disabled','disabled');
            $("#seg-depto option[value='TUTOR']").attr('disabled','disabled');
            $("#seg-depto option[value='PSICOLOGIA']").attr('disabled','disabled');
            $("#seg-btn-redactar").hide();
            $("#dir-seg-btn-guardar").hide();
            $("#psic-seg-btn-guardar").hide();
        },

        configurePsic: function(){
            $("#seg-status option[value='REGISTRADA']").attr('disabled','disabled');
            $("#seg-tipo-tutoria").attr('disabled','disabled');
            $("#seg-lb-depto").hide();
            $("#seg-depto").hide();
            $("#seg-diagnostico").attr('disabled','disabled');
            $("#seg-proposito").attr('disabled','disabled');
            $("#seg-medidas").attr('disabled','disabled');
            $("#seg-recomendaciones").attr('disabled','disabled');
            $("#dir-seg-btn-guardar").hide();
            $("#seg-btn-bitacora").hide();
            $("#tut-seg-btn-guardar").hide();

        },

        configureProf: function(){
            $("#seg-depto").attr('disabled','disabled');
            $("#seg-tipo-tutoria").attr('disabled','disabled');
            $("#seg-status").attr('disabled','disabled');
            $("#seg-lb-depto").hide();
            $("#seg-depto").hide();
            $("#seg-diagnostico").attr('disabled','disabled');
            $("#seg-proposito").attr('disabled','disabled');
            $("#seg-medidas").attr('disabled','disabled');
            $("#seg-recomendaciones").attr('disabled','disabled');
            $("#dir-seg-btn-guardar").hide();
            $("#dir-seg-btn-guardar").hide();
            $("#psic-seg-btn-guardar").hide();
            $("#seg-btn-bitacora").hide();
            $("#seg-btn-redactar").hide();

        },

        generaPdf: function(){
            var url = "report/bitacoraAlumno?periodo=" + Session.get('idPeriodo') + "&matricula=" + this.model.get('matricula');
            window.open(url, '_blank');
        },

        actualizaDepto: function(){
            var tutoria = new TutoriaModel();
            tutoria.set({id: this.model.get('idTutoria')});
            tutoria.save({departamento: $("#seg-depto").val(), tipo: 1},{
                wait:true,
                success:function(model, response) {
                    alert(response.message);
                },
                error: function(model, error) {
                    alert(error);
                }
            });
        },

        actualizaEstatus: function(){
            var tutoria = new TutoriaModel();
            tutoria.set({id: this.model.get('idTutoria')});
            tutoria.save({statusTutoria: $("#seg-status").val(), tipo: 2},{
                wait:true,
                success:function(model, response) {
                    alert(response.message);
                },
                error: function(model, error) {
                    alert(error);
                }
            });
        },

        actualizaTutoria: function(){
            var tutoria = new TutoriaModel();
            tutoria.set({id: this.model.get('idTutoria')});
            var depto = $("#seg-depto").val();
            if(depto == null){
                depto = this.model.get('departamento');
            }
            tutoria.save({statusTutoria: $("#seg-status").val(),
                            tipo: 3,
                            departamento: depto,
                            tipoTutoria: $("#seg-tipo-tutoria").val(),
                            diagnostico: $("#seg-diagnostico").val(),
                            proposito: $("#seg-proposito").val(),
                            medidas: $("#seg-medidas").val(),
                            recomendaciones: $("#seg-recomendaciones").val()
                           },{
                wait:true,
                success:function(model, response) {
                    alert(response.message);
                },
                error: function(model, error) {
                    alert(error);
                }
            });
        }
	});

	return CommonDetalleSeguimientoView;

});