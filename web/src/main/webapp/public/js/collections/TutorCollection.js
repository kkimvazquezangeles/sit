define([
	'backbone',
	'Session',
    'models/TutorModel'
], function(Backbone, Session, TutorModel){

    var TutorCollection = Backbone.Collection.extend({
        model: TutorModel,
        url: function() {
            return 'carrera/' + this.carreraId + '/tutor';
        },
        initialize: function(){
        },
        setCarreraId: function(carreraId){
            this.carreraId = carreraId;
        }
    });

	return TutorCollection;
});