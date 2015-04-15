define([
	'jquery',
	'core/BaseView',
	'text!templates/tplTutPlan.html'
], function($, BaseView, tplTutPlan){

	var TutPlanView = BaseView.extend({
        template: _.template(tplTutPlan),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return TutPlanView;

});