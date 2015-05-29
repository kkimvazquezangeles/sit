define([
	'jquery',
	'underscore',
	'core/BaseView',
	'models/PlanTutoriaModel',
	'views/CommonDetalleSeguimientoView',
	'text!templates/tplDirRegistroSeguimiento.html'
], function($, _, BaseView, PlanTutoriaModel, CommonDetalleSeguimientoView, tplDirRegistroSeguimiento){

	var DirRegistroSeguimientoView = BaseView.extend({
        template: _.template(tplDirRegistroSeguimiento),
        tagName: 'tr',

        events: {
            'click td' : 'mostrarSeguimiento'
        },

        initialize: function() {
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },

        mostrarSeguimiento: function(){
            var modelo = new PlanTutoriaModel();
            this.listenTo(modelo, 'sync', this.syncPlanTutoria);
            modelo.fetch({
                data: { tutoria: this.model.id },
                processData: true
            });
        },

        syncPlanTutoria: function(modelo){
            if (app.seguimientoDetailView != undefined) {
                app.seguimientoDetailView.destroyView();
                $("<div id='detalle-seguimiento'></div>").appendTo('.form6');
            }
            app.seguimientoDetailView = new CommonDetalleSeguimientoView({model: modelo});
            app.seguimientoDetailView.render();

        }

	});

	return DirRegistroSeguimientoView;

});