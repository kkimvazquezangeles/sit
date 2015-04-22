define([
	'jquery',
	'core/BaseView',
	'views/TutRegistroSeguimientoView',
	'collections/TutoriaCollection',
	'text!templates/tplTutSeguimiento.html',
	'Session'
], function($, BaseView, TutRegistroSeguimientoView, TutoriaCollection, tplTutSeguimiento, Session){

	var TutSeguimientoView = BaseView.extend({
        template: _.template(tplTutSeguimiento),

        events: {
        },

        initialize: function() {
            this.tutorias = new TutoriaCollection();
            this.listenTo(this.tutorias, 'add', this.agregaTutoria);
            this.tutorias.setCarreraId(Session.get('idCarrera'));
            this.tutorias.fetch({
                data: { periodo: Session.get('idPeriodo')},
                processData: true
            });

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        },

        agregaTutoria: function(modelo){
            var vista = new TutRegistroSeguimientoView({model: modelo});
            $("#grid-data").find('tbody:last').append(vista.render().$el);
        }
	});

	return TutSeguimientoView;

});