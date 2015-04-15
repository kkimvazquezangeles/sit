define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var GrupoModel = Backbone.Model.extend({

        url: function() {
            return 'carrera/cuatrimestre/grupo';
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

	return GrupoModel;
});