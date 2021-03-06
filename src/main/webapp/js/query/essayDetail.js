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
                    //console.log(res);
                }else{
                    layer.alert("Exception");
                    location.href="/yuyin";
                }
            },
            error:function(res){
                layer.alert("Exception");
                location.href="/yuyin";
            }
        });
    }
    //评论初始化
    $scope.commentquery=function(){
        var essayId=$scope.item.id;
        //console.log(essayId);
        var list=new Array();
        $.ajax({
            type:'post',
            url:'/yuyin/comment/essay',
            data:{"eId":essayId},
            success:function(res){
                //console.log(res.data);
                if(res.data!=null){
                    for(var i=0;i<res.data.length;i++){
                        list[i]={
                            content:res.data[i].content,
                            createtime:res.data[i].createtime,
                            userInfo:JSON.parse(res.data[i].formUser)
                        }
                    }
                    //console.log(list);
                    $scope.commentList =list;
                    $scope.$apply();
                }
            },
            error:function(res){
                layer.alert("Exception");
            }
        })

    }
    //收藏
    $scope.collect=function(id){
        if(userId==null||userId==undefined||userId=="null"){
            $scope.login();
            return;
        }
        $.ajax({
            type:'post',
            url:'/yuyin/insert/collect',
            data:{"userId":userId,"eId":id},
            success:function(res){
                if(res.status==200){
                    layer.alert("收藏成功");
                }else if(res.status==401){
                    layer.alert("收藏已存在");
                }else{
                    layer.alert("error");
                }
            },
            error:function(res){
                layer.alert("error");
            }
        });
    }
    //评论
    $scope.comment=function(id){
        //参数:用户id,期刊Id,评论内容
        var content=$('#commentEditor').val();
        var user={
            userId:userId,
            userName:userName,
            headImage:headImage
        }
        var userInfo=JSON.stringify(user);
        if(userId==null||userId==undefined||userId=="null"){
            $scope.login();
            return;
        }
        if(content==null||content==undefined||content==""){
            layer.msg("请输入内容");
            return;
        }
        $.ajax({
            type:'post',
            url:'/yuyin/user/comment',
            data:{"userInfo":userInfo,"eId":id,"content":content},
            success:function(res){
                //console.log(res.status);
                if(res.status==200){
                    $scope.commentquery();
                    $('#commentEditor').val('');}
                else
                    layer.alert("error")
            },
            error:function(res){}
        });
    }
    ///登录弹窗
    $scope.login=function(){
        layer.closeAll();
        $scope.signupShow=false;
        $scope.loginshow=true;
        layer.open({
            type: 1,
            title:'登录',
            offset: '100px',
            content: $('#loginContent'),
            cancel:function(){
                $scope.loginshow=false;
                $scope.$apply();
            }
        });
    }
    //登录按钮
    $scope.signIn=function(){
        //
        var param1=$scope.email;
        var param2=$scope.password;
        if(param1==undefined || param1==null||param2==undefined||param2==null){
            layer.closeAll();
            layer.alert("账户密码输入异常");
            return ;
        }
        $.ajax({
            type:'post',
            url:'/yuyin/login',
            data:{"email":param1,"password":param2},
            success:function(res){
                if(res==200){
                    layer.closeAll();
                    location.reload();
                }else if(res==404){
                    layer.alert("用户不存在");
                }
                else if(res==400){
                    layer.alert("密码错误");
                }
            },
            error:function(){
                layer.alert("异常");
            }
        })
    }
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
                    location.reload();
                }
            }
        })
    }
    //注册弹窗
    $scope.signup=function(){
        layer.closeAll();
        $scope.loginshow=false;
        $scope.signupShow=true;
        layer.open({
            type: 1,
            title:'注册',
            offset: '100px',
            content: $('#signupContent'),
            cancel:function(){
                $scope.signupShow=false;
                $scope.$apply();
            }
        });
    }
    //注册按钮
    $scope.register=function(){
        var param1=$scope.email;
        var param2=$scope.password;
        var param3=$scope.nickname;
        if(param1==undefined || param1==null||param2==undefined||param2==null||param3==undefined||param3==null){
            layer.closeAll();
            layer.alert("账户密码输入异常");
            return ;
        }
        $.ajax({
            type:'post',
            url:'/yuyin/register',
            data:{"email":param1,"password":param2,"nickname":param3},
            success:function(res){
                if(res==200){
                    layer.closeAll();
                    location.reload();
                }
                else if(res==400){
                    layer.alert("用户已存在");
                }
            },
            error:function(){
                layer.alert("异常");
            }
        })
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
        $scope.commentquery();
        if(userId==null||userId==undefined||userId=="null"){
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