define([
	'jquery',
	'core/BaseView',
	'text!templates/tplProfCanalizar.html'
], function($, BaseView, tplProfCanalizar){

	var ProfCanalizarView = BaseView.extend({
        template: _.template(tplProfCanalizar),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return ProfCanalizarView;

});