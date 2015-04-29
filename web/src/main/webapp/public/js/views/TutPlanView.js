define([
	'jquery',
	'core/BaseView',
	'models/PlanGrupalModel',
	'text!templates/tplTutPlan.html',
	'Session'
], function($, BaseView, PlanGrupalModel, tplTutPlan, Session){

	var TutPlanView = BaseView.extend({
        template: _.template(tplTutPlan),

        events: {
        },

        initialize: function() {
            var modelo = new PlanGrupalModel();
            this.listenTo(modelo, 'sync', this.syncPlanGrupal);
            modelo.fetch({
                data: { periodo: Session.get('idPeriodo'), personal: Session.get('id') },
                processData: true
            });
        },

        render: function() {
            return this;
        },

        syncPlanGrupal: function(modelo){
            this.model = modelo;
            this.$el.html(this.template(this.model.toJSON()));

        }
	});

	return TutPlanView;

});