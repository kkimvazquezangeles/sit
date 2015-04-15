define([
	'backbone',
	'Session',
    'models/GrupoModel'
], function(Backbone, Session, GrupoModel){

    var GruposCollection = Backbone.Collection.extend({
        model: GrupoModel,
        url: function() {
            return 'carrera/' + this.carrera.id + '/cuatrimestre/' + this.cuatrimestre.id + '/grupo';
        },
        initialize: function(carrera, cuatrimestre){
            this.carrera = carrera;
            this.cuatrimestre = cuatrimestre;
        }
    });

	return GruposCollection;
});