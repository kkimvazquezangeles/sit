define([
	'jquery',
	'underscore',
	'core/BaseView',
	'collections/CarrerasCollection',
    'collections/CuatrimestreCollection',
	'text!templates/tplDirTutores.html',
	'Session'
], function($, _, BaseView, CarrerasCollection, CuatrimestreCollection, tplDirTutores, Session){

	var DirTutoresView = BaseView.extend({
        template: _.template(tplDirTutores),

        events: {
            'change #dir-carrera': 'actualizaCuatrimestre'
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
        }

	});

	return DirTutoresView;

});