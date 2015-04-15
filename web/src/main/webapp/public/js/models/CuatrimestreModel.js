define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var CuatrimestreModel = Backbone.Model.extend({

        url: function() {
            return 'carrera/cuatrimestre';
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

	return CuatrimestreModel;
});