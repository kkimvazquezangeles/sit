define([
	'jquery',
	'backbone'
], function($, Backbone){

	var SessionModel = Backbone.Model.extend({
	    url : '/sit/session/user',

		getAuth : function(callback){
			var that = this;
			var Session = this.fetch();

			Session.done(function(response){
				that.set('authenticated', true);
			});

			Session.fail(function(response){
				that.set('authenticated', false);
			});

			Session.always(callback);
		}
	});

	return new SessionModel();
});