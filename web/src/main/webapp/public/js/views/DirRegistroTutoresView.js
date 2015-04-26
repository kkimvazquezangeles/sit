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

        initialize: function() {
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },

        eliminarTutor: function(event){
            var res = confirm("¿Desea eliminar esta asignación?");
            if(res){
                that = this;
                this.model.destroy({ contentType: 'application/json',
                    success: function() {
                        console.log(that.parent.collection);
                    },
                    error: function(model, error) {
                        alert(error);
                    }
                });
            }
        }

	});

	return DirRegistroTutoresView;

});