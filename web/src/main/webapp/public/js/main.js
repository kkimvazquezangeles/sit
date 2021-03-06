require.config({
    shim: {
        underscore: {
            exports: '_'
        },
        backbone: {
            deps: [
                'underscore',
                'jquery'
            ],
            exports: 'Backbone'
        },
    },
    paths: {
        backbone: 'vendor/backbone/backbone-min',
        bootstrap : 'vendor/bootstrap/bootstrap.min',
        jquery: 'vendor/jquery/jquery-min',
        moment: 'vendor/moment/moment-min',
        momentes: 'vendor/moment/locale/es',
        jquerytimeago: 'vendor/jquery-timeago/jquery.timeago',
        text : 'vendor/requirejs-text/text',
        underscore: 'vendor/underscore/underscore-min',
        bigframe: 'vendor/jquery/jquery.bgiframe-2.1.2',
        jqueryui: 'vendor/jquery/jquery-ui'
    }
});

require([
    'app'
], function (App) {
    var app = new App();
    app.start();
});