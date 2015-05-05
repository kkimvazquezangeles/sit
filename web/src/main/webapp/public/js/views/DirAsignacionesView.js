define([
	'jquery',
    'underscore',
	'core/BaseView',
	'collections/CarrerasCollection',
	'collections/PersonalCollection',
	'collections/CuatrimestreCollection',
	'collections/GruposCollection',
	'models/PersonalModel',
	'models/CarreraModel',
	'models/TutorModel',
	'text!templates/tplDirAsignaciones.html',
	'Session'
], function($, _, BaseView, CarrerasCollection, PersonalCollection, CuatrimestreCollection, GruposCollection,
            PersonalModel, CarreraModel, TutorModel, tplDirAsignaciones, Session){

	var DirAsignacionesView = BaseView.extend({
        template: _.template(tplDirAsignaciones),

        events: {
            'change #dir-carrera': 'actualizaPersonal',
            'change #dir-cuatrimestres': 'actualizaGrupos',
            'click #dir-asignar': 'asignarTutor'
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

        actualizaPersonal: function(event){
            var idCarrera = $(event.target).val();
            var modelo = this.carreras.get(idCarrera);
            this.personales = new PersonalCollection(modelo);
            this.listenTo(this.personales, 'sync', this.syncPersonal);
            //this.listenTo(this.personales, 'add', this.agregarPersonal);
            this.personales.fetch({
                data: { periodo: Session.get('idPeriodo'), perfil: Session.getRole() },
                processData: true
            });

            this.cuatrimestres = new CuatrimestreCollection(modelo);
            this.listenTo(this.cuatrimestres, 'sync', this.syncCuatrimestres);
            this.cuatrimestres.fetch({
                data: { periodo: Session.get('idPeriodo')},
                processData: true
            });


        },

        syncPersonal: function(){
            that = this;
            console.log('Terminando de Sync Personal.');
            this.personales.each(function(model){
              console.log(model);
              that.agregarPersonal(model);
            });
            $('#dir-personal').change();
        },

        agregarPersonal: function(modelo){
            console.log('Agregando Personal.');
            $('#dir-personal').append($('<option>', {
                value: modelo.get('id'),
                text : modelo.get('nombreCompleto')
            }));
        },

        syncCuatrimestres: function(){
            that = this;
            this.cuatrimestres.each(function(model){
              console.log(model);
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
            /*$("#dir-carrera").html*/
            $("#dir-grupos").html('');
            this.grupos = new GruposCollection(carrera, cuatrimestre);
            this.listenTo(this.grupos, 'sync', this.syncGrupos);
            this.grupos.fetch({
                data: { periodo: Session.get('idPeriodo'), tipo: 'asignacion' },
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
        },

        asignarTutor: function(){
            var tutor = new TutorModel();
            that = this;
            if($("#dir-personal").val()!= null && $("#dir-grupos").val()!= null){
                tutor.save({idCarrera: $("#dir-carrera").val(),
                            idPeriodoPersonal: $("#dir-personal").val(),
                            idCuatrimestre: $("#dir-cuatrimestres").val(),
                            idGrupo: $("#dir-grupos").val()}, {
                    wait:true,
                    success:function(model, response) {
                        alert(response.message);
                        Backbone.history.navigate('director/asignaciones', { trigger : true });
                        that.destroyView();
                    },
                    error: function(model, error) {
                        alert(error);
                    }
                });
            } else {
                alert("No es posible realizar la asignación, verifica los datos.");
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

	return DirAsignacionesView;

});