define([
	'jquery',
	'core/BaseView',
	'text!templates/tplProfSeguimiento.html'
], function($, BaseView, tplProfSeguimiento){

	var ProfSeguimientoView = BaseView.extend({
        template: _.template(tplProfSeguimiento),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return ProfSeguimientoView;

});