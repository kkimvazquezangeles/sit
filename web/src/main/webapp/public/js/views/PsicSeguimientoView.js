define([
	'jquery',
	'underscore',
	'core/BaseView',
	'collections/CarrerasCollection',
	'text!templates/tplPsicSeguimiento.html',
	'Session'
], function($, _,  BaseView, CarrerasCollection, tplPsicSeguimiento, Session){

	var PsicSeguimientoView = BaseView.extend({
        template: _.template(tplPsicSeguimiento),

        events: {

                },

                initialize: function() {
                    this.carreras = new CarrerasCollection();
                    this.listenTo(this.carreras, 'add', this.agregarCarrera);
                    this.listenTo(this.carreras, 'sync', this.syncCarreras);
                    this.carreras.fetch({
                        data: { periodo: Session.get('idPeriodo'), perfil: Session.getRole() },
                        processData: true
                    });

                },

                render: function() {
                    this.$el.html(this.template());
                    return this;
                },

                agregarCarrera: function(modelo){
                    $('#psi-carreras').append($('<option>', {
                        value: modelo.get('id'),
                        text : modelo.get('carrera')
                    }));
                },

                syncCarreras: function(){
                    $('#psi-carreras').change();
                }


            });

	return PsicSeguimientoView;

});