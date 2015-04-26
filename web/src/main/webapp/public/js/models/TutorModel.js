define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var TutorModel = Backbone.Model.extend({

        url: function() {
            return 'tutor/personal/' + Session.get('id');
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