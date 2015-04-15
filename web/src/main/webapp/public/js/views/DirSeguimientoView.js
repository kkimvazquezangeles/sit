define([
	'jquery',
	'core/BaseView',
	'text!templates/tplDirSeguimiento.html'
], function($, BaseView, tplDirSeguimiento){

	var DirSeguimientoView = BaseView.extend({
        template: _.template(tplDirSeguimiento),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return DirSeguimientoView;

});