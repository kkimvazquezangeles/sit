define([
	'jquery',
	'underscore',
	'core/BaseView',
	'collections/CarrerasCollection',
	'collections/TutoriaCollection',
	'views/ProfRegistroSeguimientoView',
	'text!templates/tplProfSeguimiento.html',
	'Session'
], function($, _, BaseView, CarrerasCollection, TutoriaCollection, ProfRegistroSeguimientoView, tplProfSeguimiento, Session){

	var ProfSeguimientoView = BaseView.extend({
        template: _.template(tplProfSeguimiento),

        events: {
            'change #prof-carreras': 'agregaSeguimiento'
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
            $('#prof-carreras').append($('<option>', {
                value: modelo.get('id'),
                text : modelo.get('carrera')
            }));

        },

        syncCarreras: function(){
            $('#prof-carreras').change();
        },

        agregaSeguimiento: function(event){
         $("#grid-data").find('tbody:last').html('');
         var idCarrera = $(event.target).val();
         var modelo = this.carreras.get(idCarrera);
         this.tutorias = new TutoriaCollection();
         this.tutorias.setCarreraId(modelo.get('id'));
         this.listenTo(this.tutorias, 'add', this.agregaTutoria);
         this.tutorias.fetch({
             data: { periodo: Session.get('idPeriodo')},
             processData: true
         });
        },

        agregaTutoria: function(modelo){
         var vista = new ProfRegistroSeguimientoView({model: modelo});
         $("#grid-data").find('tbody:last').append(vista.render().$el);
        }
	});

	return ProfSeguimientoView;

});