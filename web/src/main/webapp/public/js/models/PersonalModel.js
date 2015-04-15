define([
	'backbone'
], function(Backbone){

    var PersonalModel = Backbone.Model.extend({

        url: function() {
            return 'personal/carrera';
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

	return PersonalModel;
});