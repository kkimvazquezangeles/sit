define([
	'jquery',
	'underscore',
	'core/BaseView',
    'models/PlanTutoriaModel',
    'views/TutDetalleSeguimientoView',
	'text!templates/tplTutRegistroSeguimiento.html'
], function($, _, BaseView, PlanTutoriaModel, TutDetalleSeguimientoView, tplTutRegistroSeguimiento){

	var TutRegistroSeguimientoView = BaseView.extend({
        template: _.template(tplTutRegistroSeguimiento),
        tagName: 'tr',

        events: {
            'click td' : 'mostrarSeguimiento'
        },

        initialize: function() {
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },

        mostrarSeguimiento: function(){
            var modelo = new PlanTutoriaModel();
            this.listenTo(modelo, 'sync', this.syncPlanTutoria);
            modelo.fetch({
                data: { tutoria: this.model.id },
                processData: true
            });
        },

        syncPlanTutoria: function(modelo){
            var view = new TutDetalleSeguimientoView({model: modelo});
            view.render();

            $('#tut-tpo-tutoria option[value="'+modelo.get('tipoTutoria')+'"]').attr('selected', 'selected');
            $('#tut-estatus option[value="'+modelo.get('statusTutoria')+'"]').attr('selected', 'selected');
            $('#tut-depto option[value="'+modelo.get('departamento')+'"]').attr('selected', 'selected');

            $("#tut-estatus option[value='REGISTRADA']").attr('disabled','disabled');

            $("#tut-depto option[value='TUTOR']").attr('disabled','disabled');
            $("#tut-depto option[value='PSICOLOGIA']").attr('disabled','disabled');
        }
	});

	return TutRegistroSeguimientoView;

});