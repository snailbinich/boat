requirejs.config({
    baseUrl: '/public/app',
    paths: {
        jquery:'//beilouweb.b0.upaiyun.com/public/javascripts/jquery-1.11.3.min',
        angular:'../lib/angular.min',
        angularui:'../lib/ui-bootstrap-tpls-0.14.3.min',
        domReady:'../lib/domReady.min',
        app:'app',
        message:'modules/messageCtrl',
        bootstrap : '../lib/bootstrap/js/bootstrap.min',
        request:'services/request',
        lte:'../lib/lte/js/app.min',
        ajaxLoading:'./compents/loadingInterceptor'

    },
    shim:{
        'angular':{
            exports:'angular'
        },
        'angularui':[
            'angular'
        ],
        bootstrap : {
            deps : [ 'jquery' ],
            exports : 'bootstrap'
        },
        lte:["jquery"]
    },
    deps:[
        './angularInit',
        'lte'
    ]
});