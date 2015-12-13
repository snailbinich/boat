/**
 * 拦截器 全局$http注入loading效果
 */
define(['jquery', 'angular'], function($, angular){
    angular.module('ajaxLoading', [])
        .config(function($httpProvider) {
            $httpProvider.interceptors.push('loadingInterceptor');
        })
        .directive('loading', function() {
            return {
                replace: true,
                restrict: 'E',
                template:'<div class="overlay" ng-show="loading">'
                         + '<i class="fa fa-refresh fa-spin"></i>'
                         + '</div>'
            };
        })

        .factory('loadingInterceptor', function($q, $rootScope) {
            return {
                request: function(config) {
                    $rootScope.loading=true;
                    console.log("start request");
                    console.log($rootScope);
                    return config || $q.when(config);
                },
                response: function(response) {
                    $rootScope.loading=false;
                    return response || $q.when(response);
                },
                responseError: function(rejection) {
                    $rootScope.loading=false;
                    return $q.reject(rejection);
                }
            };
        });
});