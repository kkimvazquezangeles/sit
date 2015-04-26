define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var CuatrimestreMateriaModel = Backbone.Model.extend({

        url: function() {
            return 'materias';
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

	return CuatrimestreMateriaModel;
});