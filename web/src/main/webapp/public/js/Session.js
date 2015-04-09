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
		},

		getRole : function() {
            var index;
            var rolesSession = new Array();
            var roles = this.get('roles');
            for (index = 0; index < roles.length; ++index) {
                rolesSession.push(roles[index].authority);
            }

            var dir = $.inArray('DIRECTOR', rolesSession);
            var prof = $.inArray('PROFESOR', rolesSession);
            var psi = $.inArray('PSICOLOGO', rolesSession);
            var tut = $.inArray('TUTOR', rolesSession);

            if (dir > -1){
                return 'DIRECTOR';
            }

            if (tut > -1){
                return 'TUTOR';
            }

            if (prof > -1){
                return 'PROFESOR';
            }

            if (psi > -1){
                return 'PSICOLOGO';
            }
		}
	});

	return new SessionModel();
});