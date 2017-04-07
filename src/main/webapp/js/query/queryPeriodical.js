'use strict';
/*
 * 用于期刊等操作
 */
var queryPeriodicalApp=angular.module('queryPeriodicalApp',[]);

queryPeriodicalApp.config(function($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});
queryPeriodicalApp.controller('queryPeriodicalContro',function($scope,$http){
	var layer=layui.layer,laypage=layui.laypage;
	var pageNum;//当前页
	var pageRow;//一页多少条记录
	var ids=new Array();
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
			url:'/yuyin/periodical/query',
			data:{"title":param,"pageNum":param1,"pageRow":param2},
			success:function(res){
				$scope.periodicalList=res.rows;
				$scope.pageNum=res.pageNum;
				$scope.pageSize=res.pageSize;
				$scope.pageInit();
				$scope.$apply();
			},
			error:function(res){
				layer.alert("查询异常",{icon:5});
			}
		});
	}
	//初始化分页
	$scope.pageInit=function(){
		laypage({
			cont:'laypage',
			pages:$scope.pageSize,
			curr:$scope.pageNum,
			jump:function(obj,first){
				if(!first){
					var param=$scope.title;
					var param1=obj.curr;
					var param2=$scope.pageRow;
					$.ajax({
						type:'post',
						url:'/yuyin/periodical/query',
						data:{"title":param,"pageNum":param1,"pageRow":param2},
						success:function(res){
							$scope.periodicalList=res.rows;
							$scope.pageNum=res.pageNum;
							$scope.pageSize=res.pageSize;
							$scope.pageInit();
							$scope.$apply();
						},
						error:function(res){
							layer.alert("查询异常",{icon:5});
						}
					});
				}
			}
		});
	}
	//删除
	$scope.delPeriodical=function(item){
		ids.splice(0,ids.length);//清空数组
		ids.push(item.id);
		layer.alert("确定删除？",{icon:5},function(index){
			$.ajax({
				type:'post',
				url:'/yuyin/periodical/delete',
				data:JSON.stringify(ids),
				dataType:'json',
				contentType:'application/json;charset=UTF-8',
				success:function(res){
					if(res.status==400){
						layer.alert("操作成功",{icon:1},function(index){
							layer.closeAll();
							$scope.btnquery();
						});
					}else{
						layer.alert("操作异常",{icon:5});
					}
				},
				error:function(res){
					layer.alert("操作异常",{icon:5});
				}
			});
		});
		
	}
	//批量删除
	$scope.delPeriodicalIds=function(){
		ids.splice(0,ids.length);//清空数组
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
        		url:'/yuyin/periodical/delete',
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
	
	//查看详细
	$scope.showPeriodical=function (item){
		$scope.detail=item;
		$scope.showsure=true;
		layer.open({
			type:1,
			maxmin: true,
			area: ['800px', '350px'],
			content:$("#showPeriodical"),
			cancel:function(){
				$scope.showsure=false;
				$scope.$apply();
			}
		});
	}
	function init(){
		$scope.pageNum=1;
		$scope.pageRow=10;
		$scope.showsure=false;
		$scope.btnquery();
	}
	init();
});