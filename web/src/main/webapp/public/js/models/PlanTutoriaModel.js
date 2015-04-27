define([
	'backbone'
], function(Backbone){

    var PlanTutoriaModel = Backbone.Model.extend({
        urlRoot: 'planTutoria',

        defaults: {
        },

        initialize: function() {

        },

        validate: function(atributos) {

        }
    });

	return PlanTutoriaModel;
});