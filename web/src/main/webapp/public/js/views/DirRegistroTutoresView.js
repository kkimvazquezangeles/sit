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
        },

        initialize: function() {
        },

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
	});

	return DirRegistroTutoresView;

});