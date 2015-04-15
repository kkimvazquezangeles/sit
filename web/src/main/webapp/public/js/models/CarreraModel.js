define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var CarreraModel = Backbone.Model.extend({

        url: function() {
            return 'personal/' + Session.get('id') + '/periodo/'  + Session.get('idPeriodo') + '/carrera';
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

	return CarreraModel;
});