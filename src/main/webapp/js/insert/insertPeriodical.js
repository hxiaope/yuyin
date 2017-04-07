'user strict';
/*
 *createBy hxiaope  用于插入期刊
 */
var addPeriodicalApp=angular.module('addPeriodicalApp',[]);

addPeriodicalApp.config(function($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});

addPeriodicalApp.controller('addPeriodicalContro',function($http,$scope){
	var layer=layui.layer;
	var layedit=layui.layedit;
	var form=layui.form();
    layui.upload({
        url:'/yuyin/upload/picture',
        elem:'#cpicupload',
        before:function(input){//上传前的回调
			layer.load(2); //风格1的加载
        },
        success:function (res) {
        	layer.closeAll('loading');
        	if(res.code===1){
        		$("#uploadCpic").append("<img id=\"uploadCpic1\"  style=\"width: 70px;height: 70px;border:0\" src=\""+res.url+"\"></img>");
        	}else if(res.code==2){
            	layer.alert("上传失败",{icon:5});
        	}else{
            	layer.alert("上传异常",{icon:5});
        	}
        }
    });
    layui.upload({
        url:'/yuyin/upload/music',
        elem:'#musupload',
        before:function(input){//上传前的回调
			layer.load(1); //风格1的加载
        },
        success:function (res) {
        	layer.closeAll('loading');
        	if(res.code==1){
            	layer.alert("上传成功",{icon:1});
            	$scope.musicUrl=res.url;
            	$scope.$apply();
        	}else if(res.code==2){
            	layer.alert("上传失败",{icon:5});
        	}else{
            	layer.alert("上传异常",{icon:5});
        	}
        }
    });
    layui.upload({
        url:'/yuyin/upload/picture',
        elem:'#muspicupload',
        before:function(input){//上传前的回调
			layer.load(1); //风格1的加载
        },
        success:function (res) {
        	layer.closeAll('loading');
        	if(res.code==1){
            	layer.alert("上传成功",{icon:1});
            	$scope.musicPicUrl=res.url;
            	$scope.$apply();
        	}else if(res.code==2){
            	layer.alert("上传失败",{icon:5});
        	}else{
            	layer.alert("上传异常",{icon:5});
        	}
        }
    });
    var musicArr=new Array();
    $scope.uploadMusics=function (){
    	var musData={};
    	musData['musicname']=$scope.musicname;
    	musData['singer']=$scope.singer;
    	if($scope.musicUrl!=undefined && $scope.musicUrl!=null){
    		musData['musicpath']=$scope.musicUrl;
    	}
    	if($scope.musicPicUrl!=undefined && $scope.musicPicUrl!=null){
    		musData['musicimage']=$scope.musicPicUrl;
    	}
    	$.ajax({
    		type:'post',
    		url:'/yuyin/music/insert',
    		data:musData,
    		success:function(res){
    			if(res.status==400){
    				musicArr.push(res.data);
    				$scope.musicList=musicArr;
    				$scope.$apply();
    				layer.alert(res.msg);
    			}
    		},
    		error:function(res){
    			layer.alert(res.msg);
    		}
    	});
    	
    }
    $scope.clearMusic = function(){
    	//数据库删除再赋值为null
    	var mlist=$scope.musicList;
    	$.ajax({
    		type:'post',
    		url:'/yuyin/music/delete',
    		data:JSON.stringify(mlist),
    		dataType:"json",  
    	    contentType:'application/json;charset=utf-8',
    		success:function(res){
    			if(res.status==400){
    				layer.alert(res.msg);
    			}
    		},
    		error:function(res){
    			layer.alert(res.msg);
    		}
    	});
    	musicArr.splice(0,musicArr.length);//清空数组 
    }
    var edit=layedit.build('periodicalContent',{
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
        height:400,
        uploadImage: {
            url: '/yuyin/upload/editPic' //接口url
            ,type: 'post' //默认post
        }
    }); //建立编辑器
    form.verify({
	    content: function(value){
	    	return layedit.sync(edit);//同步内容到textarea
	    }
	  });
    //监听提交
    form.on('submit(formDemo)', function(data){
        //layer.msg(JSON.stringify(data.field));
    	//data.field['imagepath']=$("#uploadCpic1").attr('src');
    	//data.field['tag']=($scope.tag).join(",");
    	//var periodicalData=JSON.stringify(data.field);
    	//var periodicalData=data.field;
    	//var periodicalData=$("#perForm").serializeArray();
    	//console.log(periodicalData);
    	//var periodical=JSON.stringify(periodicalData);
    	$scope.periodicalList.imagepath=$("#uploadCpic1").attr('src');
    	$scope.periodicalList.tag=($scope.tag).join(",");
    	$scope.periodicalList.content=data.field.content;
    	$scope.periodicalList.createtime=data.field.createtime;
    	var periodical=JSON.stringify($scope.periodicalList);
    	var periodicalMlist=angular.toJson($scope.musicList);
    	//var periodicalMlist=$scope.musicList;
    	//,"list":periodicalMlist
    	debugger;
    	$.ajax({
    		type:'post',
    		url:'/yuyin/periodical/insert',
    		data:{"periodical":periodical,"list":periodicalMlist},
    		dataType:"json",  
    	   // contentType : 'application/json;charset=utf-8', //设置请求头信息  
    	    success:function(res){
    	    	layer.alert("success");
    	    },
    	    error:function (res){
    	    	layer.alert("error");
    	    }
    	});
        return false;
    });
    var arr = new Array();
    form.on('select(tagSelect)', function(data){
    	console.log(data);
    	var index = data.elem.selectedIndex; // 选中索引
    	var txt = data.elem.options[index].text; // 选中文本
    	arr.push(txt);
    	debugger;
    	$scope.tag=arr;
    	var option='<span id="tag'+data.value+'">'+txt+'</span>&nbsp;';
    	$("#selectTag").append(option);
    });
    var tagManagerService;
    function init(){
    	form=layui.form();
    	$scope.tag='';
    	$scope.periodicalList;
    	tagManagerService =new TagManagerService($http);
    	tagManagerService.queryAll(function(gdata){
    		//debugger;
    		var tagList=gdata.data;
    		$("#insertTag").empty();
    		$("#insertTag").append('<option value=""></option>');
    		for(var index in tagList){
    				var option = '<option value="' + tagList[index].id
					+ '">'
					+ tagList[index].tag + '</option>';
    				$("#insertTag").append(option);
    		}
    		form.render('select'); //刷新select选择框渲染
    	},function (gdata){
    		layer.alert("标签初始化异常",{icon:5})
    	});
    }
    init();
});
