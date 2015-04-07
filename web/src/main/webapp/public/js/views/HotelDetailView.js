define([
	'jquery',
	'underscore',
	'backbone',
	'moment',
	'momentes',
	'core/BaseView',
	'views/HotelRowSolicitudView',
	'text!templates/tplHotelDetail.html',
	'collections/SolicitudesCollection'
], function($, _, Backbone, moment, momentes, BaseView, HotelRowSolicitudView, tplHotelDetail, SolicitudesCollection){

	var HotelDetailView = BaseView.extend({
        template: _.template(tplHotelDetail),

        events: {
            'click #close-hotel-detail': 'closeHotelDetail'
        },

        initialize: function() {
            this.render();
            app.solicitudes = new SolicitudesCollection({idHotel: this.model.get('id')});
            this.listenTo(app.solicitudes, 'add', this.agregarSolicitud);
            app.solicitudes.fetch();
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));

            return this;
        },

        closeHotelDetail: function(){
            Backbone.history.navigate('', {trigger: true});
        },

        agregarSolicitud: function(modelo){
            var classSolicitud = this.generateClassByEstadoSolicitud(modelo.get('estadoSolicitud'));

            moment.locale('es');
            var fechaSolicitud = moment(new Date(modelo.get('fechaSolicitud'))).fromNow();

            modelo.set({classSolicitud: classSolicitud});
            modelo.set({fechaSolicitud: fechaSolicitud});

            var vista = new HotelRowSolicitudView({model: modelo});
            $("#hotel-solicitudes").find('tbody:last').append(vista.render().$el);

        },

        generateClassByEstadoSolicitud: function(estadoSolicitud) {
            switch (estadoSolicitud) {
                case "SOLICITADA":
                    return "success";
                case "ENPROCESO":
                    return "warning";
                case "PENDIENTE":
                    return "danger";
                case "ATENDIDA":
                    return "";
                case "CANCELADA":
                    return "active";
            }
        }
	});

	return HotelDetailView;

});