'use strict';
var essayDetailApp=angular.module('essayDetailApp',[]);
essayDetailApp.config(function($interpolateProvider){
    $interpolateProvider.startSymbol('[[').endSymbol(']]');
});
essayDetailApp.filter('trustHtml', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
});
essayDetailApp.filter('trustSrc', function ($sce) {
    return function (url) {
        return $sce.trustAsResourceUrl(url);
    }
});
essayDetailApp.controller('essayDetailContro',function($http,$scope){
    var layer=layui.layer;
    var userId=$.cookie("userId");
    var userName=$.cookie("userName");
    var headImage=$.cookie("headImage");
    $scope.query=function(){
        var str=location.href; //取得整个地址栏
        $.ajax({
            type:'post',
            url:str,
            async:false,
            success:function(res){
                if(res.status==200){
                    $scope.item=res.data;
                    console.log(res);
                }else{
                    alert("Exception");
                }
            },
            error:function(res){
                alert("Exception");
            }
        });
    }
    //评论初始化
    $scope.commentList=function(){

    }
    //收藏
    $scope.collect=function(id){
        layer.alert("请登录");
    }
    //评论
    $scope.comment=function(){
        layer.alert("请登录");
    }
    $scope.play=function(id){
        var key="#audio"+id;
        var music =$(key)[0];
        if(music.paused){
            $scope.playstatus=0;
            music.play();
        }else{
            $scope.playstatus=1;
            music.pause();
        }
    }
    function init(){
        $scope.query();
        $scope.commentList();
        if(userId==null||usesrId==undefined){
            $scope.loginStatus=1;
        }else{
            $scope.loginStatus=2;
            $scope.userName=userName;
            $scope.headImage=headImage;
            $scope.userId=userId;
        }
        $("audio").attr("autoplay","autoplay");
        $scope.playstatus=0;
    }
    init();
    $("audio").on('ended',function () {
        $scope.playstatus=1;
    })
});