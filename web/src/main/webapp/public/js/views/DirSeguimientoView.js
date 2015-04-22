define([
	'jquery',
	'underscore',
	'core/BaseView',
	'views/DirRegistroSeguimientoView',
	'collections/TutoriaCollection',
	'text!templates/tplDirSeguimiento.html',
	'Session'
], function($, _, BaseView, DirRegistroSeguimientoView, TutoriaCollection, tplDirSeguimiento, Session){

	var DirSeguimientoView = BaseView.extend({
        template: _.template(tplDirSeguimiento),

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
            var vista = new DirRegistroSeguimientoView({model: modelo});
            $("#grid-data").find('tbody:last').append(vista.render().$el);
        }

	});

	return DirSeguimientoView;

});