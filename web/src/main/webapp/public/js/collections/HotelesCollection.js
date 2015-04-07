define([
	'backbone',
    'models/HotelModel'
], function(Backbone, HotelModel){

    var HotelesCollection = Backbone.Collection.extend({
        model: HotelModel,
        url: '/hoteladn/hotel'
    });

	return HotelesCollection;
});