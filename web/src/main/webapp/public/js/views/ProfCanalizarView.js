define([
	'jquery',
	'underscore',
	'core/BaseView',
	'models/TutoriaModel',
	'collections/CarrerasCollection',
	'text!templates/tplProfCanalizar.html',
	'Session'
], function($, _, BaseView, TutoriaModel, CarrerasCollection, tplProfCanalizar, Session){

	var ProfCanalizarView = BaseView.extend({
        template: _.template(tplProfCanalizar),

        events: {
            'click #btn-enviar': 'canalizarAlumno'
        },

        initialize: function() {
            this.carreras = new CarrerasCollection();
            this.listenTo(this.carreras, 'add', this.agregarCarrera);
            this.listenTo(this.carreras, 'sync', this.syncCarreras);
            this.carreras.fetch({
                data: { periodo: Session.get('idPeriodo'), perfil: Session.getRole() },
                processData: true
            });

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        },

        agregarCarrera: function(modelo){
            $('#pro-carreras').append($('<option>', {
                value: modelo.get('id'),
                text : modelo.get('carrera')
            }));
        },

        syncCarreras: function(){
            $('#pro-carreras').change();
        },

        canalizarAlumno: function(){
             var tutoria = new TutoriaModel();
             that = this;
             tutoria.save({idCarrera: parseInt($("#pro-carreras").val()),
                         matricula: $("#matricula").val(),
                         tipoTutoria: $("#pro-tpo-tutoria").val(),
                         departamento: $("#pro-depto").val(),
                         observaciones: $("#prof-obser").val(),
                         statusTutoria: 'REGISTRADA',
                         idPeriodo: Session.get('idPeriodo'),
                         idCanalizador: Session.get('id'),
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
        }

    });

	return ProfCanalizarView;

});