define([
	'backbone',
	'Session'
], function(Backbone, Session){

    var TutorModel = Backbone.Model.extend({

        url: function() {
            if(this.tipo == 2){
                this.tipo = 1;
                return 'tutor/' + this.id;
            } else {
                return 'tutor/personal/' + Session.get('id');
            }
        },

        defaults: {
        },

        initialize: function() {
            this.on('change', function(){
            });
        },

        setTipo: function(tipo) {
            this.tipo = tipo;
        },

        validate: function(atributos) {

        }

    });

	return TutorModel;
});