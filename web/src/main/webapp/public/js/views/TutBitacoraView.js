define([
	'jquery',
	'core/BaseView',
	'text!templates/tplTutBitacora.html'
], function($, BaseView, tplTutBitacora){

	var TutBitacoraView = BaseView.extend({
        template: _.template(tplTutBitacora),

        events: {
        },

        initialize: function() {

        },

        render: function() {
            this.$el.html(this.template());
            return this;
        }
	});

	return TutBitacoraView;

});