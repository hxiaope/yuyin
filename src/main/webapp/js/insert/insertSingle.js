"use strict";
/*
 *createBy hxiaope  用于插入单曲 
 */
var addSingleApp = angular.module('addSingleApp', []);

addSingleApp.config(function ($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});
addSingleApp.controller('addSingleContro',function($scope,$http){
	var form = layui.form(),layer=layui.layer;
	//音乐图片上传
	layui.upload({
		url:'/yuyin/upload/picture',
		elem:'#mpicupload',//选定dom节点
		before:function(input){//上传前的回调
			layer.load(1); //风格1的加载
        },
        success:function (res) {//上传后的回调
        	layer.closeAll('loading');
        	if(res.code==1){
            	layer.alert(res.url+"上传成功",{icon:1});
            	$("#uploadMpic").append("<img id=\"uploadMpic1\"  style=\"width: 70px;height: 70px;border:0\" src=\""+res.url+"\"></img>");
            	$scope.$apply();
        	}else if(res.code==2){
            	layer.alert("上传失败",{icon:5});
        	}else{
            	layer.alert("上传异常",{icon:5});
        	}
        }
	});
	//音乐文件上传
	layui.upload({
		url:'/yuyin/upload/music',
		elem:'#musicupload',//选定dom节点
		before:function(input){//上传前的回调
			layer.load(2); //风格1的加载
        },
        success:function (res) {//上传后的回调
        	layer.closeAll('loading');
        	if(res.code==1){
            	layer.alert("上传成功",{icon:1});
            	$("#uploadMsic").append("<audio id=\"uploadMsic1\" src=\""+res.url+"\" controls=\"controls\">");
        	}else if(res.code==2){
            	layer.alert("上传失败",{icon:5});
        	}else{
            	layer.alert("上传异常",{icon:5});
        	}
        }
	});
	//封面图片上传
	layui.upload({
		url:'/yuyin/upload/picture',
		elem:'#cpicupload',//选定dom节点
		before:function(input){//上传前的回调
			layer.load(2); //风格1的加载
        },
        success:function (res) {//上传后的回调
        	layer.closeAll('loading');
        	if(res.code==1){
            	layer.alert("上传成功",{icon:1});
            	$("#uploadCpic").append("<img id=\"uploadCpic1\"  style=\"width: 70px;height: 70px;border:0\" src=\""+res.url+"\"></img>");
        	}else if(res.code==2){
            	layer.alert("上传失败",{icon:5});
        	}else{
            	layer.alert("上传异常",{icon:5});
        	}
        }
	});
	form.on('submit(singleForm)', function(data){
		data.field['singleimage']=$("#uploadCpic1").attr('src');
		data.field['musicimage']=$("#uploadMsic1").attr('src');
		data.field['musicpath']=$("#uploadMpic1").attr('src');
		var singleData = data.field;
		singleService.insert(singleData,function (gdata){
			if(gdata.status==200){
				layer.alert("添加成功",{icon:1});
			}else{
				layer.alert("添加失败",{icon:5});
			}
		},function (gdata){
			layer.alert("添加失败",{icon:5});
		});
        return false;
    });
	
	//调用服务类js
	var singleService;
	function init(){
		singleService = new SingleService($http);
	}
	init();
});