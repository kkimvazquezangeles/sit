define([
	'backbone',
    'models/CuatrimestreModel'
], function(Backbone, CuatrimestreModel){

    var CuatrimestreCollection = Backbone.Collection.extend({
        model: CuatrimestreModel,
        url: function() {
            return 'carrera/' + this.carrera.id + '/cuatrimestre';
        },
        initialize: function(carrera){
            this.carrera = carrera;
        }
    });

	return CuatrimestreCollection;
});