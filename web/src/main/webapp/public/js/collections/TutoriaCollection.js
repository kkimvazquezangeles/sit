define([
	'backbone',
    'models/TutoriaModel'
], function(Backbone, TutoriaModel){

    var TutoriaCollection = Backbone.Collection.extend({
        model: TutoriaModel,
        url: function() {
            return 'carrera/' + this.carreraId + '/seguimiento';
        },
        initialize: function(){
        },
        setCarreraId: function(carreraId){
            this.carreraId = carreraId;
        }
    });

	return TutoriaCollection;
});