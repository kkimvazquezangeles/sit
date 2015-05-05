define([
	'jquery',
	'core/BaseView',
	'models/TutoriaModel',
	'text!templates/tplTutBitacora.html',
	'Session'
], function($, BaseView, TutoriaModel, tplTutBitacora, Session){

	var TutBitacoraView = BaseView.extend({
        template: _.template(tplTutBitacora),

        events: {
        'click #btn-guardar': 'registrarTutoriaAlumno'
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        },

        registrarTutoriaAlumno: function(){
             var tutoria = new TutoriaModel();
             that = this;
             if($("#matricula").val()!= '' && $("#tpo-tutoria").val()!= '' && $("#diagnostico").val()!= ''){
                 tutoria.save({idCarrera: Session.get('idCarrera'),
                             matricula: $("#matricula").val(),
                             tipoTutoria: $("#tpo-tutoria").val(),
                             departamento: $("#depto").val(),
                             statusTutoria: 'ENPROCESO',
                             idPeriodo: Session.get('idPeriodo'),
                             idCanalizador: Session.get('id'),
                             diagnostico: $("#diagnostico").val(),
                             proposito: $("#proposito").val(),
                             medidas: $("#medidas").val(),
                             recomendaciones: $("#recomendaciones").val(),
                             nombreAlumno: '',
                             nombreTutor: ''},{
                     wait:true,
                     success:function(model, response) {
                         alert(response.message);
                     },
                     error: function(model, error) {
                         alert(error);
                     }
                 });
             } else {
                alert("Tutoria no registrada, verifica los datos.");
             }
        }
	});

	return TutBitacoraView;

});