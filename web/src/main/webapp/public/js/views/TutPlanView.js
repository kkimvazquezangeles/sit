define([
	'jquery',
	'core/BaseView',
	'models/PlanGrupalModel',
	'models/PlanDetalleModel',
	'text!templates/tplTutPlan.html',
	'Session'
], function($, BaseView, PlanGrupalModel, PlanDetalleModel, tplTutPlan, Session){

	var TutPlanView = BaseView.extend({
        template: _.template(tplTutPlan),

        events: {
            'click #tut-plan-guardar': 'guardarPlan'
        },

        initialize: function() {
            var modelo = new PlanGrupalModel();
            this.listenTo(modelo, 'sync', this.syncPlanGrupal);
            modelo.fetch({
                data: { periodo: Session.get('idPeriodo'), personal: Session.get('id') },
                processData: true
            });
        },

        render: function() {
            return this;
        },

        syncPlanGrupal: function(modelo){
            this.model = modelo;
            this.$el.html(this.template(this.model.toJSON()));

        },

        guardarPlan: function(event){
            this.populateModel();
            this.model.save({
                wait:true,
                success:function(model, response) {
                    alert(response.message);
                },
                error: function(model, error) {
                    alert(error);
                }
            });
        },

        populateModel: function(){
            this.model.set({
                diagnostico: $('#tut-plan-diagnostico').val(),
                proposito: $('#tut-plan-proposito').val(),
                medidas: $('#tut-plan-medida').val(),
                recomendaciones: $('#tut-plan-recomendacion').val(),
                idTutor: Session.get('id')
            });
            var acts = [];
            for (iCont = 1; iCont <= 8; iCont++) {
                var valMes = $("input:radio:checked[name='act" + iCont + "']").val();
                var valAct = $("input:text[name='acttx" + iCont + "']").val();
                if (valMes != 'undefined' && valAct != 'undefined' && valAct != '') {
                    acts.push(new PlanDetalleModel({actividad: valAct, mes: valMes}));
                }
            }
            //this.model.set({ actividades:acts });
        }
	});

	return TutPlanView;

});