"use strict";
/*
 * 公共Service类
 */

//单曲操作
function SingleService($http){
	this.insert = function (jsonData,successCallback, errCallback){
		if($http!=undefined){
			var p=$http({
				method : 'post',
				url : '/yuyin/single/insert',
				params : jsonData,
				headers : {
					contentType : 'application/json;charset=UTF-8'
				}
			});
			p.success(function (gdata){
				if(typeof successCallback === 'function')
	            	successCallback(gdata, status);
			});
			p.error(function(gdata) {
	 			if(typeof errCallback === 'function')
					errCallback(gdata, status);
			});	
		}else{
			$.ajax({
				type:'post',
				url:'/yuyin/single/insert',
				data:jsonData,
				success: function(gdata){
					if(typeof successCallback === 'function')
		            	successCallback(gdata);
	            },
	            error:function(gdata){
					if(typeof errCallback === 'function')
		            	errCallback(gdata);
	            }
			});
		}
	}
	this.query = function (jsonData,successCallback, errCallback){
		if($http!=undefined){
			var p=$http({
				method : 'post',
				url : '',
				params : jsonData,
				headers : {
					contentType : 'application/json;charset=UTF-8'
				}
			});
			p.success(function (data){
				if(typeof successCallback === 'function')
	            	successCallback(data, status);
			});
			p.error(function(data, status) {
	 			if(typeof errCallback === 'function')
					errCallback(data, status);
			});	
		}else{
			$.ajax({
				type:'post',
				url:'',
				data:jsonData,
				success: function(data){
					if(typeof successCallback === 'function')
		            	successCallback(data, status);
	            },
	            error:function(data){
					if(typeof errCallback === 'function')
		            	errCallback(data, status);
	            }
			});
		}
	}
	this.del = function (jsonData,successCallback, errCallback){
		if($http!=undefined){
			var p=$http({
				method : 'post',
				url : '',
				params : jsonData,
				headers : {
					contentType : 'application/json;charset=UTF-8'
				}
			});
			p.success(function (data){
				if(typeof successCallback === 'function')
	            	successCallback(data, status);
			});
			p.error(function(data, status) {
	 			if(typeof errCallback === 'function')
					errCallback(data, status);
			});	
		}else{
			$.ajax({
				type:'post',
				url:'',
				data:jsonData,
				success: function(data){
					if(typeof successCallback === 'function')
		            	successCallback(data, status);
	            },
	            error:function(data){
					if(typeof errCallback === 'function')
		            	errCallback(data, status);
	            }
			});
		}
	}
	this.modify = function (jsonData,successCallback, errCallback){
		if($http!=undefined){
			var p=$http({
				method : 'post',
				url : '',
				params : jsonData,
				headers : {
					contentType : 'application/json;charset=UTF-8'
				}
			});
			p.success(function (data){
				if(typeof successCallback === 'function')
	            	successCallback(data, status);
			});
			p.error(function(data, status) {
	 			if(typeof errCallback === 'function')
					errCallback(data, status);
			});	
		}else{
			$.ajax({
				type:'post',
				url:'',
				data:jsonData,
				success: function(data){
					if(typeof successCallback === 'function')
		            	successCallback(data, status);
	            },
	            error:function(data){
					if(typeof errCallback === 'function')
		            	errCallback(data, status);
	            }
			});
		}
	}
	
}

//标签管理
function TagManagerService($http){
	this.query = function(tagParam,pageNum,pageRow,successCallback,errCallback){
		$.ajax({
			type:'post',
			url:'/yuyin/tagManager/query',
			data:{"tagParam":tagParam,"pageNum":pageNum,"pageRow":pageRow},
			success: function (data){
				if(typeof successCallback ==='function')
					successCallback(data);
			},
			error:function(data){
				if(typeof errCallback ==='function'){
					errCallback(data);
				}
			}
		});
	}
	this.add=function (tagParam,successCallback,errCallback){
		$.ajax({
			type:'post',
			url:'/yuyin/tag/insert',
			data:{"param":tagParam},
			success: function (data){
				if(typeof successCallback ==='function')
					successCallback(data);
			},
			error:function(data){
				if(typeof errCallback ==='function'){
					errCallback(data);
				}
			}
		});
	}
	this.del=function (id,successCallback,errCallback){
		$.ajax({
			type:'post',
			url:'/yuyin/tag/delete',
			data:{"id":id},
			success: function (data){
				if(typeof successCallback ==='function')
					successCallback(data);
			},
			error:function(data){
				if(typeof errCallback ==='function'){
					errCallback(data);
				}
			}
		});
	}
	
	this.mdf = function (id,tagParam,successCallback,errCallback){
		$.ajax({
			type:'post',
			url:'/yuyin/tag/modify',
			data:{"tag":tagParam,"id":id},
			success: function (data){
				if(typeof successCallback ==='function')
					successCallback(data);
			},
			error:function(data){
				if(typeof errCallback ==='function'){
					errCallback(data);
				}
			}
		});
	}
	this.queryAll=function(successCallback, errCallback){
		if($http!=undefined){
			var p=$http({
				method:'post',
				url:'/yuyin/tagManager/queryAll',
				headers : {
					contentType : 'application/json;charset=UTF-8'
				}
			});
			p.success(function (data){
				if(typeof successCallback === 'function')
	            	successCallback(data);
			});
			p.error(function(data, status) {
	 			if(typeof errCallback === 'function')
					errCallback(data);
			});
		}else{
			$.ajax({
				type:'pspt',
				url:'/yuyin/tagManager/queryAll',
				success:function (data){
					if(typeof successCallback === 'function')
		            	successCallback(data);
				},
				error:function(data){
					if(typeof errCallback === 'function')
						errCallback(data);
				}
			})
		}
	}
}