define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var TutoriaModel = Backbone.Model.extend({

        url: function() {
            return 'tutoria';
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

	return TutoriaModel;
});