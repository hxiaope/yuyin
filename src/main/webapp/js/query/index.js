'use strict';
var indexApp=angular.module('indexApp',[]);

indexApp.config(function($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});
indexApp.controller('indexController',function($scope,$http){
	var layer=layui.layer;
    var userId=$.cookie("userId");
    var userName=$.cookie("userName");
    var headImage=$.cookie("headImage");
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
		layer.closeAll();
	}
	function init(){
		$scope.queryPeriodical();
		$scope.queryEssay();
		$scope.querySingle();
        if(userId==null||usesrId==undefined){
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