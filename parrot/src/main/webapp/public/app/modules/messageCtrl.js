/**
 * Author：Zhaoyan
 * Description: 消息管理模块
 */
define(["jquery","app","request"],function ($,app) {
    'use strict';
    var reqUrls={
        "list":"/message/list"
    };
    return  app.controller('messageCtrl',function($scope, $http, request){
        $scope.totalItems = 0;
        $scope.currentPage = 1;
        $scope.pageSize = 1;

        $scope.setPage = function (pageNo) {
            $scope.currentPage = pageNo;
        };

        $scope.pageChanged = function() {
            $scope.list($scope.currentPage);
        };


        $scope.list = function(page){
            if(!page || page < 1){
                page = 1;
            }
            $http.get(reqUrls["list"]+"?page="+page).success(function(resp) {
                if(resp.code == 200){
                    $scope.totalItems = resp.data.totalItems;
                    $scope.currentPage = resp.data.currentPage;
                    $scope.pageSize = resp.data.pageSize;
                    $scope.messages = resp.data.data;
                }else{
                    alert(resp.data);
                }

            });
        }
        $scope.list(1);
    });
})

