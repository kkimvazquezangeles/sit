Leagues.League = DS.Model.extend({
  name: DS.attr('string'),
  officialName: DS.attr('string'),
  country: DS.attr('string'),
  organizeBy: DS.attr('string'),
  foundigDate: DS.attr('date')
});

// ... additional lines truncated for brevity ...
Leagues.League.FIXTURES = [
 {
   id: 1,
   name: 'LNBP México',
   officialName: 'Liga Nacional de Baloncesto Profesional',
   country: 'México',
   organizeBy: 'Federación Mexicana de Baloncesto',
   foundigDate: null
 },
 {
   id: 2,
   name: 'LNBP México 2',
   officialName: 'Liga Nacional de Baloncesto Profesional 2',
   country: 'México',
   organizeBy: 'Federación Mexicana de Baloncesto',
   foundigDate: null
 },
 {
   id: 3,
   name: 'LNBP México 3',
   officialName: 'Liga Nacional de Baloncesto Profesional 3',
   country: 'México',
   organizeBy: 'Federación Mexicana de Baloncesto',
   foundigDate: null
 }
];