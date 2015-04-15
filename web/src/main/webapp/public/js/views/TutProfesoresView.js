define([
	'jquery',
	'core/BaseView',
	'text!templates/tplTutProfesores.html'
], function($, BaseView, tplTutProfesores){

	var TutProfesoresView = BaseView.extend({
        template: _.template(tplTutProfesores),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return TutProfesoresView;

});