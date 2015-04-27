define([
	'jquery',
	'underscore',
	'core/BaseView',
    'models/PlanTutoriaModel',
    'views/CommonDetalleSeguimientoView',
	'text!templates/tplPsicRegistroSeguimiento.html'
], function($, _, BaseView, PlanTutoriaModel, CommonDetalleSeguimientoView, tplPsicRegistroSeguimiento){

	var PsicRegistroSeguimientoView = BaseView.extend({
        template: _.template(tplPsicRegistroSeguimiento),
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
            var view = new CommonDetalleSeguimientoView({model: modelo});
            view.render();
        }

	});

	return PsicRegistroSeguimientoView;

});