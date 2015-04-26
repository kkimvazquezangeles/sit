define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplProfRegistroSeguimiento.html'
], function($, _, BaseView, tplProfRegistroSeguimiento){

	var ProfRegistroSeguimientoView = BaseView.extend({
        template: _.template(tplProfRegistroSeguimiento),
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

	return ProfRegistroSeguimientoView;

});