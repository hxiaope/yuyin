'user strict';
/*
 * 查询单曲页面的操作
 */
var querySingleApp=angular.module('querySingleApp',[]);

querySingleApp.config(function($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});
querySingleApp.controller('querySingleContro',function($scope,$http){
	var layer=layui.layer;
	var laypage=layui.laypage;
	var form = layui.form();
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
		var param=$scope.musicname;
		var param1=$scope.pageNum;
		var param2=$scope.pageRow;
		$.ajax({
			type:'post',
			url:'/yuyin/single/query',
			data:{"pageNum":param1,"pageRow":param2,"musicname":param},
			success:function (res){
				$scope.singleList=res.rows;
				$scope.pageSize=res.pageSize;
				$scope.pageNum=res.pageNum;
				$scope.laypageInit();
				$scope.$apply();
			},
			error:function (res){
				layer.alert("查询异常",{icon:5});
			}
		})
	}
	//分页初始化
	$scope.laypageInit = function(){
		laypage({
	    	cont:'laypage',
	    	pages:$scope.pageSize,
	    	curr:$scope.pageNum,
	    	jump:function (obj,first){
	    		if(!first){
	    			var param=$scope.musicname;
	    			var param1=obj.curr;
	    			var param2=$scope.pageRow;
	    			//请求
	    			$.ajax({
	    				type:'post',
	    				url:'/yuyin/single/query',
	    				data:{"pageNum":param1,"pageRow":param2,"musicname":param},
	    				success:function (res){
	    					$scope.singleList=res.rows;
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
	$scope.delSingle=function (item){
		ids.splice(0,ids.length);//清空数组
		ids.push(item.id);
		var idlist=JSON.stringify(ids);
		layer.alert("确定删除？",{icon:5},function(index){
			$.ajax({
				type:'post',
				url:'/yuyin/single/delete',
				data:idlist,
				//data:{ids:ids},
				dataType:"json",
			    contentType:"application/json",
				success:function(res){
					if(res.status==400){
						layer.alert("操作成功",{icon:1},function(){
							layer.closeAll();
							$scope.btnquery();
						});
					}else{
						layer.alert("操作异常",{icon:5});
					}
				},
				errro:function(res){
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
		//alert(ids);
		console.log(ids);
		if(ids.length==0){
			layer.alert("没有勾选项目");
			return;
		}
		layer.alert("确定删除？",{icon:5},function(index){
			//layer.alert(JSON.stringify(ids));
			$.ajax({
				type:'post',
				url:'/yuyin/single/delete',
				data:JSON.stringify(ids),
				//data:{ids:ids},
				dataType:"json",
			    contentType:"application/json",
				success:function(res){
					if(res.status==400){
						layer.alert("操作成功",{icon:1},function(){
							layer.closeAll();
							$scope.btnquery();
						});
					}else{
						layer.alert("操作异常",{icon:5});
					}
				},
				errro:function(res){
					layer.alert("操作失败",{icon:5});
				}
			});
		});
	}
	//修改
	$scope.mdfSingle=function (item){
		$scope.detail=item;
		$scope.showsure=true;
		layer.open({
			type:1,
			maxmin: true,
			area: ['800px', '350px'],
			content:$("#showForm"),
			cancel:function(){
				$scope.showsure=false;
				$scope.$apply();
			}
		});
		
	}
	
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
            	layer.alert("上传成功",{icon:1});
            	$scope.detail.musicimage=res.url;
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
            	$scope.detail.musicpath=res.url;
            	$scope.$apply();
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
            	$scope.detail.singleimage=res.url;
                $scope.$apply();
        	}else if(res.code==2){
            	layer.alert("上传失败",{icon:5});
        	}else{
            	layer.alert("上传异常",{icon:5});
        	}
        }
	});
	//提交监听
	form.on('submit(singleForm)', function(data){
		var singleData = data.field;
		console.log(singleData);
		$.ajax({
			type:'post',
			url:'/yuyin/single/update',
			data:singleData,
			success:function(res){
				if(res.status==200){
					layer.alert("操作成功",{icon:1});
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
	var pageNum;//当前页
	var pageRow;//一页展示多少行
	var ids=new Array();
	function init(){
		$scope.pageNum=1;
		$scope.pageRow=10;
		$scope.showsure=false;
		$scope.btnquery();
	}
	init();
});