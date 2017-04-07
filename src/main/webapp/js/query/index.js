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
	function init(){
		$scope.queryPeriodical();
		$scope.queryEssay();
		$scope.querySingle();
	}
	init();
});