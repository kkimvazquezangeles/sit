define([
	'jquery',
	'core/BaseView',
	'text!templates/tplTutSeguimiento.html'
], function($, BaseView, tplTutSeguimiento){

	var TutSeguimientoView = BaseView.extend({
        template: _.template(tplTutSeguimiento),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return TutSeguimientoView;

});