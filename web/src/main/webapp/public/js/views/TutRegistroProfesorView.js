define([
	'jquery',
	'underscore',
	'core/BaseView',
	'text!templates/tplTutRegistroProfesor.html'
], function($, _, BaseView, tplTutRegistroProfesor){

	var TutRegistroProfesorView = BaseView.extend({
        template: _.template(tplTutRegistroProfesor),
        tagName: 'tr',

        events: {
        },

        initialize: function() {
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
	});

	return TutRegistroProfesorView;

});