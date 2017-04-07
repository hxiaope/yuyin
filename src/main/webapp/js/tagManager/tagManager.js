"use strict";
/*
 *createBy hxiaope  用于标签管理
 */
var tagManagerApp = angular.module('tagManagerApp',[]);
tagManagerApp.config(function ($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});
tagManagerApp.controller('tagManagerController',function ($scope,$http){
	var layer=layui.layer,laypage=layui.laypage;
	// 表格选中
    $('#dateTable tbody').on( 'click', 'tr input[type="checkbox"]', function () {
        var obj = $(this).parent().parent();
        if(this.checked){
            obj.addClass('checked');
        }else{
            obj.removeClass('checked');
        }
    });
    // 全选和反选
    $('#dateTable thead').on( 'click', 'tr input[type="checkbox"]', function () {
        var obj = $("#dateTable tbody input[type='checkbox']:checkbox");
        if(this.checked){
            obj.prop("checked", true);
        }else{
            obj.prop("checked", false);
        }
    });
	
	//修改
	$scope.mdfTag=function (item){
	     layer.open({
	         content:'<input type="text" id="updataTag" class="layui-input" value='+item.tag+'>',
	         title:'修改标签',
	         area:['200px','180px'],
	         closeBtn:1,
	         btn:['保存 '],yes:function (index,layero) {
	        	 var upTag =$("#updataTag").val();
	        	 tagManagerService.mdf(item.id,upTag,function(data){
	        			 if(data.status=="01"){
	        				 layer.alert("修改成功",{icon: 1},function (index){
	        					 layer.close(index);
	        					 $scope.btnquery();
	        				 });
	        			 }else{
	        				 layer.alert("修改失败",{icon: 5});
	        			 }
	        		 },function (data){
	        			 layer.alert("修改失败",{icon: 5});
	        		 });
	         }
	     });
	}
	//删除
	$scope.delTag=function(item){
	    layer.open({
	        content:'确认删除',
	        title:'提示信息',
	        closeBtn:1,
	        icon:2,
	        btn:['确定'],yes:function (index,layero) {
	        	tagManagerService.del(item.id,function(data){
	        			if(data.status=="01"){
	        				layer.alert("删除成功",{icon: 1},function (index){
	        					layer.close(index);
	        					$scope.btnquery();
	        				});
	        			}
	        			else{
	        				 layer.alert("删除失败",{icon: 5});
	        			}
	        		},function (data){
	        			 layer.alert("删除失败",{icon: 5});
	        		});
	        }
	    });
	}
	//新增
    $scope.btnadd=function(){
    	layer.open({
            content:'<input type="text" id="insertTag" class="layui-input"/>',
            title:'新增标签',
            area:['200px','180px'],
            closeBtn:1,
            btn:['添加'],yes:function (index,layero) {
            		var paramadd=$("#insertTag").val();
            	tagManagerService.add(paramadd,function (data){
            			if(data.status=="01"){
            				layer.alert("新增成功",{icon: 1},function(index){
            					layer.close(index);
            					$scope.btnquery();
            				});
            			}else{
            				layer.alert("新增失败",{icon: 5});
            			}
            		},
            		function(data){
            			layer.alert("新增失败",{icon: 5});
            	});
    		}
        });
    }
    
    //查询
    $scope.btnquery = function (){
    	if($scope.tagParam!=undefined){
    		var param1=$scope.tagParam;
    	}
    	var param2=$scope.pageNum;
    	var param3=$scope.pageRow;
    	
    	tagManagerService.query(param1,param2,param3,function(gdata){
    		$scope.$apply(function(){
    			$scope.pageSize=gdata.pageSize;
    			$scope.pageNum=gdata.pageNum;
    			$scope.list=gdata.rows;
    			$scope.laypageInit();
    		});
    	},function(gdata){
    		layer.alert("查询异常");
    	});
    }
    
    /*
     * 分页查询
     */
    $scope.laypageInit =function(){
    //var psize=$scope.pageSize;
    laypage({
    	cont:'laypage',
    	pages:$scope.pageSize,
    	curr:$scope.pageNum,
    	jump:function (obj,first){
    		if(!first){
    			var curr=obj.curr;
    			/*if($scope.tagParam!=null){
    				$scope.pageNum=1;
    			}*/
    			var param1=$scope.tagParam;
    			var param2=curr;
    			var param3=$scope.pageRow;
    	    	tagManagerService.query(param1,param2,param3,function(gdata){
    	    		$scope.$apply(function(){
    	    			$scope.pageSize=gdata.pageSize;
    	    			$scope.pageNum=gdata.pageNum;
    	    			$scope.list=gdata.rows;
    	    		});
    	    	},function(gdata){
    	    		layer.alert("查询异常");
    	    	});
    		}
    	}
    });
    }
    var pageNum;   //页码
	var pageRow;  //多少行
	var tagManagerService;
	function init(){
		tagManagerService = new TagManagerService($http);
		$scope.pageNum =1;
		$scope.pageRow =10;
		$scope.btnquery();
	}
	init();
});



