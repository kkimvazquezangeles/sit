define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplResumenSolicitud.html',
], function($, _, BaseView, tplResumenSolicitud){

	var SolicitudDetailView = BaseView.extend({
        template: _.template(tplResumenSolicitud),

        events: {
        },

        initialize: function() {
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
	});

	return SolicitudDetailView;

});