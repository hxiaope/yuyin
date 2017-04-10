'use strict';
var userApp=angular.module('userApp',[]);
userApp.config(function($interpolateProvider){
    $interpolateProvider.startSymbol('[[').endSymbol(']]');
});
userApp.filter('trustHtml', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
});
userApp.filter('trustSrc', function ($sce) {
    return function (url) {
        return $sce.trustAsResourceUrl(url);
    }
});
userApp.controller('userController',function($http,$scope){
    var layer=layui.layer;
    var userId=$.cookie("userId");
    var userName=$.cookie("userName");
    var headImage=$.cookie("headImage");
    //退出按钮
    $scope.logout=function(){
        $.ajax({
            type:'post',
            url:'/yuyin/logout',
            success:function(res){
                if(res=200){
                    $.cookie("userId",null, { path: "/"})
                    $.cookie("userName",null, { path: "/"})
                    $.cookie("headImage",null, { path: "/"})
                    location.href="/yuyin";
                }
            }
        })
    }
    function init(){
        $scope.userName=userName;
        $scope.headImage=headImage;
        $scope.userId=userId;
    }
    init();
})