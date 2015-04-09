define([
	'jquery',
	'core/BaseView',
	'text!templates/tplDirAsignaciones.html'
], function($, BaseView, tplDirAsignaciones){

	var DirAsignacionesView = BaseView.extend({
        template: _.template(tplDirAsignaciones),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return DirAsignacionesView;

});