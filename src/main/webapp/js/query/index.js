'use strict';
var indexApp=angular.module('indexApp',[]);

indexApp.config(function($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});
indexApp.controller('indexController',function($scope,$http){
	var layer=layui.layer;
	$scope.queryPeriodical =function(){
		$.ajax({
			type:'post',
			url:'/yuyin/periodical',
			success:function(res){
				if(res.rows!=null){
					$scope.periodical1=res.rows[0];
					$scope.periodical2=res.rows[1];
					$scope.periodical3=res.rows[2];
					$scope.$apply();
				}
			},
			error:function(res){
				layer.alert("异常",{icon:5});
			}
		});
	}
	$scope.queryEssay =function(){
		$.ajax({
			type:'post',
			url:'/yuyin/essay',
			success:function(res){
				if(res.rows!=null){
					$scope.essay1=res.rows[0];
					$scope.essay2=res.rows[1];
					$scope.$apply();
				}
			},
			error:function(res){
				layer.alert("异常",{icon:5});
			}
		});
	}
	$scope.querySingle=function(){
		$.ajax({
			type:'post',
			url:'/yuyin/single',
			success:function(res){
				if(res.rows!=null){
					$scope.single=res.rows[0];
					$scope.$apply();
				}
			},
			error:function(res){
				layer.alert("异常",{icon:5});
			}
		});
	};
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
                    location.href="/yuyin"
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
			url:'',
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
                    location.href="/yuyin";
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
    var userId=$.cookie("userId");
    var userName=$.cookie("userName");
    var headImage=$.cookie("headImage");
	function init(){
		$scope.queryPeriodical();
		$scope.queryEssay();
		$scope.querySingle();
        if(userId==null||userId==undefined||userId=="null"){
            $scope.loginStatus=1;
        }else{
            $scope.loginStatus=2;
            $scope.userName=userName;
            $scope.headImage=headImage;
            $scope.userId=userId;
        }
	}
	init();
});