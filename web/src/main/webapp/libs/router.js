Leagues.Router.map(function() {
  this.resource('entuliga', { path: '/' });
  this.resource('leagues');
  this.resource('season');
});

// ... additional lines truncated for brevity ...
Leagues.LeaguesRoute = Ember.Route.extend({
  model: function() {
    return this.store.find('league');
  }
});