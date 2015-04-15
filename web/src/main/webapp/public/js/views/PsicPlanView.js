define([
	'jquery',
	'underscore',
	'core/BaseView',
	'collections/CarrerasCollection',
    'collections/CuatrimestreCollection',
    'collections/GruposCollection',
	'text!templates/tplPsicPlan.html',
	'Session'
], function($, _, BaseView, CarrerasCollection, CuatrimestreCollection, GruposCollection, tplPsicPlan, Session){

	var PsicPlanView = BaseView.extend({
        template: _.template(tplPsicPlan),

        events: {
                    'change #psi-carreras': 'actualizaCuatrimestre',
                    'change #psi-cuatrimestres': 'actualizaGrupos'
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
                    $('#psi-carreras').append($('<option>', {
                        value: modelo.get('id'),
                        text : modelo.get('carrera')
                    }));
                },

                syncCarreras: function(){
                    $('#psi-carreras').change();
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
                    $('#psi-cuatrimestres').change();
                },

                agregarCuatrimestres: function(modelo){
                    $('#psi-cuatrimestres').append($('<option>', {
                        value: modelo.get('id'),
                        text : modelo.get('cuatrimestre')
                    }));
                },

                actualizaGrupos: function(event){
                    var idCarrera = $("#psi-carreras").val();
                    var idCuatrimestre = $(event.target).val();
                    var carrera = this.carreras.get(idCarrera);
                    var cuatrimestre = this.cuatrimestres.get(idCuatrimestre);
                    $("#psi-grupos").html('');
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
                    $('#psi-grupos').change();
                },

                agregarGrupos: function(modelo){
                    $('#psi-grupos').append($('<option>', {
                        value: modelo.get('id'),
                        text : modelo.get('grupo')
                    }));
                }
        	});

	return PsicPlanView;

});