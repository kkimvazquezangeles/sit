define([
	'backbone'
], function(Backbone){

    var SolicitudModel = Backbone.Model.extend({

        urlRoot: '/hoteladn/hotel/{idHotel}/solicitud',

        defaults: {
            fechaSolicitud: new Date()
        },

        initialize: function() {
            console.log('Se ha creado una nueva instancia del Modelo Solicitud.');

            this.on('change', function(){
                console.log('El modelo ha sido modificado.');
            });
        },

        validate: function(atributos) {
            if(!atributos.id) {
                return 'Debe tener un id.';
            }
            if(!atributos.habitacionId) {
                return 'Debe tener una habitacion la solicitud.';
            }
            if(!atributos.servicioId) {
                return 'Debe tener un servicio la solicitud.';
            }
        }

    });

	return SolicitudModel;
});
