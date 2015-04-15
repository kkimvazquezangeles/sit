define([
	'backbone',
	'Session',
    'models/CarreraModel'
], function(Backbone, Session, CarreraModel){

    var CarrerasCollection = Backbone.Collection.extend({
        model: CarreraModel,
        url: function() {
            return 'personal/' + Session.get('id') + '/carrera';
        },
        initialize: function(){
        }
    });

	return CarrerasCollection;
});