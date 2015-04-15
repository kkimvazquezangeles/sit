define([
	'backbone',
    'models/PersonalModel'
], function(Backbone, PersonalModel){

    var PersonalCollection = Backbone.Collection.extend({
        model: PersonalModel,
        url: function() {
            return 'personal/carrera/' + this.carrera.id;
        },
        initialize: function(carrera){
            this.carrera = carrera;
        }
    });

	return PersonalCollection;
});