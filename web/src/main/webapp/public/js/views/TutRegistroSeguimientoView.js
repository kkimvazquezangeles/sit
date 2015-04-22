define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplTutRegistroSeguimiento.html'
], function($, _, BaseView, tplTutRegistroSeguimiento){

	var TutRegistroSeguimientoView = BaseView.extend({
        template: _.template(tplTutRegistroSeguimiento),
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

	return TutRegistroSeguimientoView;

});