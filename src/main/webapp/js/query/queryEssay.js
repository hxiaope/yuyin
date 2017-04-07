'use strict';
/*
 * 专栏查询等操作
 */
var queryEssayApp=angular.module('queryEssayApp',[]);

queryEssayApp.config(function($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});
queryEssayApp.controller('queryEssayContro',function($scope,$http){
	var layer=layui.layer,laypage=layui.laypage;
	var form=layui.form(),layedit=layui.layedit;;
	var pageRow;
	var pageNum;
	
	// 表格选中
    $('#dateTable tbody').on( 'click', 'tr input[type="checkbox"]', function () {
        var obj = $(this).parent().parent();
        console.log(obj.val());
        if(this.checked){
            obj.addClass('checked');
        }else{
            obj.removeClass('checked');
        }
    });
    // 全选和反选
    $('#dateTable thead').on( 'click', 'tr input[type="checkbox"]', function () {
        var obj = $("#dateTable tbody input[type='checkbox']:checkbox");
        console.log(obj.val());
        if(this.checked){
            obj.prop("checked", true);
        }else{
            obj.prop("checked", false);
        }
    });
    //查询
    $scope.btnquery=function(){
    	var param=$scope.title;
		var param1=$scope.pageNum;
		var param2=$scope.pageRow;
		$.ajax({
			type:'post',
			url:'/yuyin/essay/query',
			data:{"title":param,"pageNum":param1,"pageRow":param2},
			success:function(res){
				$scope.essayList=res.rows;
				$scope.pageSize=res.pageSize;
				$scope.laypageInit();
				$scope.$apply();
			},
			error:function(res){
				//layer.alert("查询失败",{icon:5});
				layer.alert("查询异常",{icon:5});
			}
		});
    }
    //分页初始化
    $scope.laypageInit=function(){
		laypage({
	    	cont:'laypage',
	    	pages:$scope.pageSize,
	    	curr:$scope.pageNum,
	    	jump:function (obj,first){
	    		if(!first){
	    			var param=$scope.title;
	    			var param1=obj.curr;
	    			var param2=$scope.pageRow;
	    			//请求
	    			$.ajax({
	    				type:'post',
	    				url:'/yuyin/essay/query',
	    				data:{"pageNum":param1,"pageRow":param2,"musicname":param},
	    				success:function (res){
	    					$scope.essayList=res.rows;
	    					$scope.pageSize=res.pageSize;
	    					$scope.pageNum=res.pageNum;
	    					$scope.laypageInit();
	    					$scope.$apply();
	    				},
	    				error:function (res){
	    					layer.alert("查询异常",{icon:5});
	    				}
	    			});
	    		}
	    	}
	    });
    }
    //删除
    $scope.delEssay=function(item){
    	ids.splice(0,ids.length);
    	ids.push(item.id);
    	console.log(ids);
    	layer.alert("确定删除？",{icon:5},function(index){
    		$.ajax({
        		type:'post',
        		url:'/yuyin/essay/delete',
        		data:JSON.stringify(ids),
        		dataType:"json",
        		contentType:'application/json;charset=UTF-8',
        		success:function(res){
        			if(res.status==400){
        				layer.alert("操作成功",{icon:1},function(index){
        					layer.closeAll();
        					$scope.btnquery();
        				})
        			}else{
        				layer.alert("操作异常",{icon:5});
        			}
        		},
        		error:function(res){
        			layer.alert("操作失败",{icon:5});
        		}
        	});
    	});
    }
    //批量删除
    $scope.deleteIds=function(){
    	ids.splice(0,ids.length);
    	$("input:checkbox[name=id]:checked").each(function(){
			ids.push($(this).val());
		});
    	console.log(ids);
		if(ids.length==0){
			layer.alert("没有勾选项目");
			return;
		}
    	layer.alert("确定删除？",{icon:5},function(index){
    		$.ajax({
        		type:'post',
        		url:'/yuyin/essay/delete',
        		data:JSON.stringify(ids),
        		dataType:"json",
        		contentType:'application/json;charset=UTF-8',
        		success:function(res){
        			if(res.status==400){
        				layer.alert("操作成功",{icon:1},function(index){
        					layer.closeAll();
        					$scope.btnquery();
        				})
        			}else{
        				layer.alert("操作异常",{icon:5});
        			}
        		},
        		error:function(res){
        			layer.alert("操作失败",{icon:5});
        		}
        	});
    	});
    }
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
        		$scope.detail.musicimage=res.url;
        		$scope.$apply();
            	layer.alert("上传成功",{icon:1});
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
        		$scope.detail.musicpath=res.url;
        		$scope.$apply();
            	layer.alert("上传成功",{icon:1});
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
        		$scope.detail.imagepath=res.url;
        		$scope.$apply();
            	layer.alert("上传成功",{icon:1});
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
        height:300,
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
		var essaydata = data.field;
		console.log(essaydata);
		$.ajax({
			type:'post',
			url:'/yuyin/essay/update',
			data:essaydata,
			success: function(gdata){
				if(gdata.status==200){
					layer.alert("操作成功",{icon:1},function(){
						$scope.showsure=false;
						layer.closeAll();
						$scope.btnquery();
					});
				}else{
					layer.alert("操作失败",{icon:5});
				}
            },
            error:function(gdata){
            	layer.alert("操作失败",{icon:5});
            }
		});
        return false;
    });
	//修改
	$scope.mdfEssay =function(item){
    	$scope.detail=item;
    	$("#layeditEssay").val(item.content);
    	$scope.showsure=true;
    	layer.open({
    		type:1,
			maxmin: true,
			area: ['900px', '350px'],
			content:$("#showForm"),
			cancel:function(){
				$scope.showsure=false;
				$scope.$apply();
			}
    	});
    }
    var ids=new Array();
	function init(){
		$scope.pageNum=1;
		$scope.pageRow=10;
		$scope.content="";
		$scope.showsure=false;
		$scope.btnquery();
	}
	init();
});
