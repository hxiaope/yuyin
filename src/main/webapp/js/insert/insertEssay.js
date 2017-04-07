"use strict";
/*
 *createBy hxiaope  用于插入专栏
 */

var addEssayApp = angular.module('addEssayApp', []);

addEssayApp.config(function ($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});

addEssayApp.controller('addEssayContro',function ($scope,$http){
	var form=layui.form(),layer=layui.layer,layedit=layui.layedit;
	//音乐图片上传
	layui.upload({
		url:'/yuyin/upload/picture',
		elem:'#mpicupload',//选定dom节点
		before:function(input){//上传前的回调
			layer.load(2); //风格1的加载
        },
        success:function (res) {//上传后的回调
        	layer.closeAll('loading');
        	if(res.code==1){
            	layer.alert(res.url+"上传成功",{icon:1});
            	$("#uploadMpic").append("<img id=\"uploadMpic1\"  style=\"width: 70px;height: 70px;border:0\" src=\""+res.url+"\"></img>");
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
	//建立编辑器
	var indexText=layedit.build('layeditEssay',{
        tool: [
            'strong' //加粗
            ,'italic' //斜体
            ,'underline' //下划线
            ,'del' //删除线

            ,'|' //分割线

            ,'left' //左对齐
            ,'center' //居中对齐
            ,'right' //右对齐
            ,'link' //超链接
            ,'unlink' //清除链接
            ,'image' //插入图片
        ],
        height:500,
        uploadImage: {
            url: '/yuyin/upload/editPic' //接口url
            ,type: 'post' //默认post
     }
    });
	form.verify({
	    content: function(value){
	    	return layedit.sync(indexText);
	    }
	  });
	form.on('submit(essayForm)', function(data){
        ///var formDate=JSON.stringify(data.field);
		data.field['imagepath']=$("#uploadCpic1").attr('src');
		data.field['musicimage']=$("#uploadMsic1").attr('src');
		data.field['musicpath']=$("#uploadMpic1").attr('src');
		var essaydata = data.field;
		console.log(essaydata);
		$.ajax({
			type:'post',
			url:'/yuyin/essay/insert',
			data:essaydata,
			success: function(gdata){
				if(gdata.status==200){
					layer.alert("添加成功",{icon:1});
				}else{
					layer.alert("添加失败",{icon:5});
				}
            },
            error:function(gdata){
            	layer.alert("添加失败",{icon:5});
            }
		});
        return false;
    });
	function init(){
	}
	init();
});
