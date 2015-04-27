define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplRegistroTutores.html'
], function($, _, BaseView, tplRegistroTutores){

	var DirRegistroTutoresView = BaseView.extend({
        template: _.template(tplRegistroTutores),
        tagName: 'tr',

        events: {
            'click #btn-eliminar' : 'eliminarTutor'
        },

        initialize: function(modelo) {
            this.model = modelo;
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },

        eliminarTutor: function(event){
            var res = confirm("¿Desea eliminar esta asignación?");
            if(res){
                this.model.setTipo(2);
                that = this;
                this.model.destroy({ contentType: 'application/json',
                wait:true,
                    success: function(model, response) {
                        that.destroyView();
                        alert(response.message);
                    },
                    error: function(model, error) {
                        alert(error);
                    }
                });
            }
        },

        destroyView: function() {
            // COMPLETELY UNBIND THE VIEW
            this.undelegateEvents();
            this.$el.removeData().unbind();
            // Remove view from DOM
            this.remove();
            Backbone.View.prototype.remove.call(this);
        }

	});

	return DirRegistroTutoresView;

});