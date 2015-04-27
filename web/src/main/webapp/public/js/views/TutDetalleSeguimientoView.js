define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplTutDetalleSeguimiento.html'
], function($, _, BaseView, tplTutDetalleSeguimiento){

	var TutDetalleSeguimientoView = BaseView.extend({
	    el: '#detalle-seguimiento',

        template: _.template(tplTutDetalleSeguimiento),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
        }
	});

	return TutDetalleSeguimientoView;

});