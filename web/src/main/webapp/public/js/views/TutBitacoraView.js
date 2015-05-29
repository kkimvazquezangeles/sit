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
        $("#btn-guardar").attr('disabled','disabled');
             var tutoria = new TutoriaModel();
             that = this;
             if($("#matricula").val()!= '' && $("#tpo-tutoria").val()!= 'Seleccionar' &&
                $("#diagnostico").val()!= '' && $("#depto").val()!= 'Depto.'){
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
                             nombreTutor: '',
                             rol: Session.getRole()},{
                     wait:true,
                     success:function(model, response) {
                        if(response.code == "success"){
                            alert(response.message);
                            Backbone.history.navigate('tutor/bitacora', { trigger : true });
                            that.destroyView();
                        } else {
                            alert(response.message);
                            $("#btn-guardar").removeAttr("disabled");
                        }

                     },
                     error: function(model, error) {
                         alert(error);
                         Backbone.history.navigate('tutor/bitacora', { trigger : true });
                         that.destroyView();
                     }
                 });
             } else {
                alert("Tutoria no registrada, verifica los datos.");
                $("#btn-guardar").removeAttr("disabled");
             }
        },

        destroyView: function() {
            // COMPLETELY UNBIND THE VIEW
            this.undelegateEvents();
            this.$el.removeData().unbind();
            // Remove view from DOM
            this.remove();
            Backbone.View.prototype.remove.call(this);
        }
	});

	return TutBitacoraView;

});