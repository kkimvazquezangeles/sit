define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplPsicRegistroSeguimiento.html'
], function($, _, BaseView, tplPsicRegistroSeguimiento){

	var PsicRegistroSeguimientoView = BaseView.extend({
        template: _.template(tplPsicRegistroSeguimiento),
        tagName: 'tr',

        events: {
        },

        initialize: function() {
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }

	});

	return PsicRegistroSeguimientoView;

});