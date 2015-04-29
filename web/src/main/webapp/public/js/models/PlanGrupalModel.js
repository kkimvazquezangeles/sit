define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var PlanGrupalModel = Backbone.Model.extend({

        url: function() {
            return 'planGrupal';
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

	return PlanGrupalModel;
});