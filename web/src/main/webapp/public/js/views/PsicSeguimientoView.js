define([
	'jquery',
	'core/BaseView',
	'text!templates/tplPsicSeguimiento.html'
], function($, BaseView, tplPsicSeguimiento){

	var PsicSeguimientoView = BaseView.extend({
        template: _.template(tplPsicSeguimiento),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return PsicSeguimientoView;

});