Leagues.LeagueController = Ember.ObjectController.extend({
  officialName: function(key, value){
    var model = this.get('model');

    if (value === undefined) {
      // property being used as a getter
      return model.get('officialName');
    } else {
      // property being used as a setter
      model.set('officialName', value);
      model.save();
      return value;
    }
  }.property('model.officialName')
});