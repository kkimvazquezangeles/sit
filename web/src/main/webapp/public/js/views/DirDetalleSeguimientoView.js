define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplDirDetalleSeguimiento.html'
], function($, _, BaseView, tplDirDetalleSeguimiento){

	var DirDetalleSeguimientoView = BaseView.extend({
	    el: '#detalle-seguimiento',

        template: _.template(tplDirDetalleSeguimiento),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
        }
	});

	return DirDetalleSeguimientoView;

});