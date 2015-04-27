define([
	'jquery',
	'underscore',
	'core/BaseView',
	'views/DirRegistroTutoresView',
	'collections/CarrerasCollection',
    'collections/CuatrimestreCollection',
    'collections/TutorCollection',
	'text!templates/tplDirTutores.html',
	'Session'
], function($, _, BaseView, DirRegistroTutoresView, CarrerasCollection, CuatrimestreCollection, TutorCollection, tplDirTutores, Session){

	var DirTutoresView = BaseView.extend({
        template: _.template(tplDirTutores),

        events: {
            'change #dir-carrera': 'actualizaCuatrimestre',
            'click #btn-pdf' : 'generaPdf'
        },

        initialize: function() {
            this.carreras = new CarrerasCollection();
            this.listenTo(this.carreras, 'add', this.agregarCarrera);
            this.listenTo(this.carreras, 'sync', this.syncCarreras);
            this.carreras.fetch({
                data: { periodo: Session.get('idPeriodo'), perfil: Session.getRole() },
                processData: true
            });

            app.tutores = new TutorCollection();
            this.listenTo(app.tutores, 'add', this.agregaTutor);

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        },

        agregarCarrera: function(modelo){
            $('#dir-carrera').append($('<option>', {
                value: modelo.get('id'),
                text : modelo.get('carrera')
            }));
        },

        syncCarreras: function(){
            $('#dir-carrera').change();
        },

        actualizaCuatrimestre: function(event){
            var idCarrera = $(event.target).val();
            var modelo = this.carreras.get(idCarrera);
            this.cuatrimestres = new CuatrimestreCollection(modelo);
            this.listenTo(this.cuatrimestres, 'sync', this.syncCuatrimestres);
            this.cuatrimestres.fetch({
                data: { periodo: Session.get('idPeriodo')},
                processData: true
            });

            app.tutores.setCarreraId(idCarrera);
            this.actualizaTutores();

        },

        syncCuatrimestres: function(){
            that = this;
            this.cuatrimestres.each(function(model){
              that.agregarCuatrimestres(model);
            });
            $('#dir-cuatrimestres').change();
        },

        agregarCuatrimestres: function(modelo){
            $('#dir-cuatrimestres').append($('<option>', {
                value: modelo.get('id'),
                text : modelo.get('cuatrimestre')
            }));
        },

        generaPdf: function(){
            var url = "report/tutor?periodo=" + Session.get('idPeriodo') + "&carrera=" + $('#dir-carrera').val();
            window.open(url, '_blank');
        },

        agregaTutor: function(modelo){
            var vista = new DirRegistroTutoresView(modelo);
            $("#grid-data").find('tbody:last').append(vista.render().$el);
        },

        actualizaTutores: function(){
            app.tutores.fetch({
                data: { periodo: Session.get('idPeriodo') },
                processData: true
            });
        }
	});

	return DirTutoresView;

});