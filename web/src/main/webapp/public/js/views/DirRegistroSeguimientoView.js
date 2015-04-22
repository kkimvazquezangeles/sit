define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplDirRegistroSeguimiento.html'
], function($, _, BaseView, tplDirRegistroSeguimiento){

	var DirRegistroSeguimientoView = BaseView.extend({
        template: _.template(tplDirRegistroSeguimiento),
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

	return DirRegistroSeguimientoView;

});