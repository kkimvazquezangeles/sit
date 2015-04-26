define([
	'backbone',
    'models/CuatrimestreMateriaModel'
], function(Backbone, CuatrimestreMateriaModel){

    var CuatrimestreMateriaCollection = Backbone.Collection.extend({
        model: CuatrimestreMateriaModel,
        url: function() {
            return 'materias/' + 'carrera/' + this.carreraId + '/cuatrimestre/' + this.cuatrimestreId + '/grupo/' + this.grupoId;
        },
        initialize: function(){
        },

        setCarreraId: function(carreraId){
            this.carreraId = carreraId;
        },

        setCuatrimestreId: function(cuatrimestreId){
            this.cuatrimestreId = cuatrimestreId;
        },

        setGrupoId: function(grupoId){
            this.grupoId = grupoId;
        }

    });

	return CuatrimestreMateriaCollection;
});