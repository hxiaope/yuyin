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
    var form = layui.form();
    var laypage=layui.laypage;
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
    //单曲收藏查询
    $scope.singleCollect=function(){
        //console.log(userId);
        $.ajax({
            type:'post',
            url:'/yuyin/user/single',
            data:{"userId":userId},
            success:function(res){
                if(res.data!=null){
                   // console.log(res.data);
                    $scope.showSelect=1;
                    $scope.singleList=res.data;
                    $scope.$apply();
                }else
                    layer.alert("异常");
            },error:function(res){
                layer.alert("异常");
            }
        })
    }
    //期刊收藏查询
    $scope.periodicalCollect=function(){
        //console.log(userId);
        $.ajax({
            type:'post',
            url:'/yuyin/user/periodical',
            data:{"userId":userId},
            success:function(res){
                if(res.data!=null){
               // console.log(res.data);
                $scope.showSelect=2;
                $scope.periodicalList=res.data;
                $scope.$apply();
                }else
                    layer.alert("异常");
            },error:function(res){
                layer.alert("异常");
            }
        })
    }
    //文章收藏查询
    $scope.essayCollect=function(){
       //console.log(userId);
        $.ajax({
            type:'post',
            url:'/yuyin/user/essay',
            data:{"userId":userId},
            success:function(res){
                if(res.data!=null){
                //console.log(res.data);
                $scope.showSelect=3;
                $scope.essayList=res.data;
                $scope.$apply();
                }else
                    layer.alert("异常");
            },error:function(res){
                layer.alert("异常");
            }
        })
    }
    //删除单曲收藏
    $scope.delScollect=function(sId){
        //console.log(sId);
        layer.alert("确定删除？",{icon:5},function(){
            $.ajax({
                type:'post',
                url:'/yuyin/collect/delete',
                data:{"userId":userId,"sId":sId},
                success:function(res){
                    if(res.status==200){
                        layer.alert("success",{icon:1});
                        $scope.singleCollect();
                    }
                    else
                        layer.alert("error",{icon:5});
                },
                error:function(res){
                    layer.alert("error",{icon:5});
                }
            });
        });
    }
    //删除期刊收藏
    $scope.delPcollect=function(pId){
        //console.log(pId);
        layer.alert("确定删除？",{icon:5},function(){
            $.ajax({
                type:'post',
                url:'/yuyin/collect/delete',
                data:{"userId":userId,"pId":pId},
                success:function(res){
                    if(res.status==200){
                        layer.alert("success",{icon:1});
                        $scope.periodicalCollect();
                    }
                    else
                        layer.alert("error",{icon:5});
                },
                error:function(res){
                    layer.alert("error",{icon:5});
                }
            });
        });
    }
    //删除文章收藏
    $scope.delEcollect=function(eId){
       // console.log(eId);
        layer.alert("确定删除？",{icon:5},function(){
            $.ajax({
                type:'post',
                url:'/yuyin/collect/delete',
                data:{"userId":userId,"eId":eId},
                success:function(res){
                    if(res.status==200){
                        layer.alert("success",{icon:1});
                        $scope.essayCollect();
                    }
                    else
                        layer.alert("error",{icon:5});
                },
                error:function(res){
                    layer.alert("error",{icon:5});
                }
            });
        });
    }
    //修改用户资料
    $scope.mdfUserInfo=function(){
        $scope.showsure=true;
        layer.open({
            type:1,
            title:'修改资料',
            maxmin: true,
            area: ['800px', '350px'],
            content:$("#showForm"),
            cancel:function(){
                $scope.showsure=false;
                $scope.$apply();
            }
        });
    }
    //用户 头像图片上传
    layui.upload({
        url:'/yuyin/upload/picture',
        elem:'#headupload',//选定dom节点
        before:function(input){//上传前的回调
            layer.load(1); //风格1的加载
        },
        success:function (res) {//上传后的回调
            layer.closeAll('loading');
            if(res.code==1){
                layer.alert("上传成功",{icon:1});
                $scope.headImage=res.url;
                $scope.$apply();
            }else if(res.code==2){
                layer.alert("上传失败",{icon:5});
            }else{
                layer.alert("上传异常",{icon:5});
            }
        }
    });
    //提交监听
    form.on('submit(userForm)', function(data){
        var userInfo = data.field;
        var pwd=$('#password1').val();
        if(!new RegExp(pwd).test(userInfo.password)) {
            layer.alert('两次输入的密码不一致')
            return;
        }
        //console.log(userInfo);
        $.ajax({
            type:'post',
            url:'/yuyin/user/update',
            data:userInfo,
            success:function(res){
                if(res.status==200){
                    layer.closeAll();
                    layer.alert("操作成功",{icon:1});
                }else if(res.status==401){
                    layer.alert("操作异常",{icon:5});
                }else{
                    layer.alert("操作失败",{icon:5});
                }
            },
            error:function(res){
                layer.alert("操作失败",{icon:5});
            }
        });
        return false;
    });
    function init(){
        form=layui.form();
        form.render('radio');
        $scope.userName=userName;
        $scope.headImage=headImage;
        $scope.userId=userId;
        $scope.essayCollect();
        $scope.periodicalCollect();
        $scope.singleCollect();
        $scope.showSelect=1;
        $scope.showsure=false;
    }
    init();
})