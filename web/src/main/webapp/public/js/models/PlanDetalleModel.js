define([
	'backbone'
], function(Backbone){

    var PlanDetalleModel = Backbone.Model.extend({
        urlRoot: 'planDetalle',

        defaults: {
        },

        initialize: function() {

        },

        validate: function(atributos) {

        }
    });

	return PlanDetalleModel;
});