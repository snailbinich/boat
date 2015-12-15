/**
 * Author：Zhaoyan
 * Description: 会话管理模块
 */
define(["jquery","app","request"],function ($,app) {
    'use strict';
    var reqUrls={
        "list":"/message/list"
    };
    return  app.controller('sessionCtrl',function($scope, $http, request){

        $scope.auth = function(){
            console.log(auth);
        }

        $scope.$watch("email",function(newValue, oldValue){
            console.log("newValue:"+newValue);
            console.log('oldValue:'+oldValue);
        });
    });
})

