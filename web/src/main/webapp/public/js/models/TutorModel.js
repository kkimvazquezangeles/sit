define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var TutorModel = Backbone.Model.extend({

        url: function() {
            return 'carrera/tutor';
        },

        defaults: {
        },

        initialize: function() {
            this.on('change', function(){
            });
        },

        validate: function(atributos) {

        }

    });

	return TutorModel;
});