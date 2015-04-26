define([
	'jquery',
	'underscore',
	'core/BaseView',
	'views/TutRegistroProfesorView',
	'collections/CuatrimestreMateriaCollection',
	'models/TutorModel',
	'models/CuatrimestreMateriaModel',
	'text!templates/tplTutProfesores.html',
	'Session'
], function($, _, BaseView, TutRegistroProfesorView, CuatrimestreMateriaCollection, TutorModel, CuatrimestreMateriaModel, tplTutProfesores, Session){

	var TutProfesoresView = BaseView.extend({
        template: _.template(tplTutProfesores),

        events: {
        },

        initialize: function() {
            this.tutor = new TutorModel();
            this.listenTo(this.tutor, 'sync', this.mostrarTutor);
            this.tutor.fetch({
                 data: { periodo: Session.get('idPeriodo') },
                 processData: true
             });

            this.materiaCuatrimestres = new CuatrimestreMateriaCollection();
            this.listenTo(this.materiaCuatrimestres, 'add', this.agregaMateriaProfesor);
        },

        render: function() {
            this.$el.html(this.template());
            return this;
        },

        mostrarTutor: function() {
            $('#tut-cuatrimestre').val(this.tutor.get('idCuatrimestre'));
            $('#tut-cuatrimestre').html(this.tutor.get('cuatrimestre'));

            $('#tut-grupo').val(this.tutor.get('idGrupo'));
            $('#tut-grupo').html(this.tutor.get('grupo'));

            /*$('#tut-grupo').append($('<a>', {
                value: this.tutor.get('idGrupo'),
                text : this.tutor.get('grupo')
            }));*/

            this.materiaCuatrimestres.setCarreraId(Session.get('idCarrera'));
            this.materiaCuatrimestres.setCuatrimestreId($('#tut-cuatrimestre').val());
            this.materiaCuatrimestres.setGrupoId($('#tut-grupo').val());
            this.materiaCuatrimestres.fetch({
                 data: { periodo: Session.get('idPeriodo') },
                 processData: true
             });
        },

        agregaMateriaProfesor: function(modelo){
            var vista = new TutRegistroProfesorView({model: modelo});
            $("#grid-data").find('tbody:last').append(vista.render().$el);
        }
	});

	return TutProfesoresView;

});