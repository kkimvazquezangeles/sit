define([
	'backbone',
    'models/SolicitudModel'
], function(Backbone, SolicitudModel){

    var SolicitudesCollection = Backbone.Collection.extend({
        model: SolicitudModel,
        url: function() {
            return '/hoteladn/hotel/' + this.hotel.idHotel + '/solicitud';
        },
        initialize: function(hotel){
            this.hotel = hotel;
        }
    });

	return SolicitudesCollection;
});