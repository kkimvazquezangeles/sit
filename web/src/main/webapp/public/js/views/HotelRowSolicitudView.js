define([
	'jquery',
	'underscore',
	'core/BaseView',
	'views/SolicitudDetailView',
	'text!templates/tplHotelRowSolicitud.html'
], function($, _, BaseView, SolicitudDetailView, tplHotelRowSolicitud){

	var HotelRowSolicitudView = BaseView.extend({
        template: _.template(tplHotelRowSolicitud),
        tagName: 'tr',

        events: {
            'click #ver-solicitud': 'showDetailSolicitud'
        },

        initialize: function() {
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            this.$el.addClass( this.model.get('classSolicitud') );
            return this;
        },

        showDetailSolicitud: function(event){
            var modelo = app.solicitudes.get($(event.target).attr('value'));
            var vista = new SolicitudDetailView({model: modelo});
            $("#detail-solicitud").html(vista.render().$el);
        }
	});

	return HotelRowSolicitudView;

});