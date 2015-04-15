define([
	'jquery',
	'underscore',
	'core/BaseView',
	'collections/CarrerasCollection',
	'collections/CuatrimestreCollection',
	'collections/GruposCollection',
	'text!templates/tplDirPlan.html',
	'Session'
], function($, _, BaseView, CarrerasCollection, CuatrimestreCollection, GruposCollection, tplDirPlan, Session){

	var DirPlanView = BaseView.extend({
        template: _.template(tplDirPlan),

        events: {
            'change #dir-carrera': 'actualizaCuatrimestre',
            'change #dir-cuatrimestres': 'actualizaGrupos'
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
        },

        actualizaGrupos: function(event){
            var idCarrera = $("#dir-carrera").val();
            var idCuatrimestre = $(event.target).val();
            var carrera = this.carreras.get(idCarrera);
            var cuatrimestre = this.cuatrimestres.get(idCuatrimestre);
            $("#dir-grupos").html('');
            this.grupos = new GruposCollection(carrera, cuatrimestre);
            this.listenTo(this.grupos, 'sync', this.syncGrupos);
            this.grupos.fetch({
                data: { periodo: Session.get('idPeriodo') },
                processData: true
            });
        },

        syncGrupos: function(){
            that = this;
            this.grupos.each(function(model){
              that.agregarGrupos(model);
            });
            $('#dir-grupos').change();
        },

        agregarGrupos: function(modelo){
            $('#dir-grupos').append($('<option>', {
                value: modelo.get('id'),
                text : modelo.get('grupo')
            }));
        }
	});

	return DirPlanView;

});