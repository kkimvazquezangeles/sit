define([
	'jquery',
	'underscore',
	'core/BaseView',
	'collections/CarrerasCollection',
	'text!templates/tplProfCanalizar.html',
	'Session'
], function($, _, BaseView, CarrerasCollection, tplProfCanalizar, Session){

	var ProfCanalizarView = BaseView.extend({
        template: _.template(tplProfCanalizar),

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
            $('#pro-carreras').append($('<option>', {
                value: modelo.get('id'),
                text : modelo.get('carrera')
            }));
        },

        syncCarreras: function(){
            $('#pro-carreras').change();
        }


    });

	return ProfCanalizarView;

});