Leagues.LeaguesController = Ember.ArrayController.extend({
  actions: {
    createLeague: function() {
      // Get the todo title set by the "New Todo" text field
      var name = this.get('newName');
      var officialName = this.get('newOfficialName');
      var country = this.get('newCountry');
      if (!officialName) { return false; }
      if (!officialName.trim()) { return; }

      // Create the new Todo model
      var league = this.store.createRecord('league', {
        officialName: officialName,
        name: name,
        country: country
      });

      // Clear the "New Todo" text field
      this.set('newTitle', '');
      this.set('newOfficialName', '');
      this.set('newCountry', '');

      // Save the new model
      league.save();
    }
  }
});