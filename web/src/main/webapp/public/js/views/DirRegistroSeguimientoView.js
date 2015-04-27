define([
	'jquery',
	'underscore',
	'core/BaseView',
	'models/PlanTutoriaModel',
	'views/DirDetalleSeguimientoView',
	'text!templates/tplDirRegistroSeguimiento.html'
], function($, _, BaseView, PlanTutoriaModel, DirDetalleSeguimientoView, tplDirRegistroSeguimiento){

	var DirRegistroSeguimientoView = BaseView.extend({
        template: _.template(tplDirRegistroSeguimiento),
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
            var view = new DirDetalleSeguimientoView({model: modelo});
            view.render();

            $('#dir-tpo-tutoria option[value="'+modelo.get('tipoTutoria')+'"]').attr('selected', 'selected');
            $('#dir-estatus option[value="'+modelo.get('statusTutoria')+'"]').attr('selected', 'selected');
            $('#dir-depto option[value="'+modelo.get('departamento')+'"]').attr('selected', 'selected');

            $("#dir-depto option[value='TUTOR']").attr('disabled','disabled');
            $("#dir-depto option[value='DIRECCION']").attr('disabled','disabled');
        }

	});

	return DirRegistroSeguimientoView;

});