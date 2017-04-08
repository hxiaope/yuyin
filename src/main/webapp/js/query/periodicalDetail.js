'use strict'; 
var pdetailApp=angular.module('pdetailApp',[]);
pdetailApp.config(function($interpolateProvider){
	$interpolateProvider.startSymbol('[[').endSymbol(']]');
});
pdetailApp.controller('pdetailContro',function($scope){
	var playlist= new Array();
	var layer=layui.layer;
	var userId=$.cookie("userId");
	var userName=$.cookie("userName");
	var headImage=$.cookie("headImage");
	$scope.query=function(){
		 var str=location.href; //取得整个地址栏
		 $.ajax({
			 type:'post',
			 url:str,
			 async:false,
			 success:function(res){
				 if(res.status==200){
					 $scope.item=res.data;
					 playlist=res.data.music;
					 //console.log(res);
					 //console.log(1);
					 //console.log(res.data.music);
					 //console.log(2);
				 }else{
					alert("Exception");
				 }
			 },
			 error:function(res){
				alert("Exception"); 
			 }
		 });
	}
	//收藏
	$scope.collect=function(periodicalId){
        if(userId==null||userId==undefined||userId=="null"){
            $scope.login();
            return;
		}
	}
	//评论
	$scope.comment=function(){
		//参数:用户id,期刊Id,评论内容
		var content=$('#commentEditor').val();
		//console.log(content);
        if(userId==null||userId==undefined||userId=="null"){
            $scope.login();
            return;
        }
        if(content==null||content==undefined||content==""){
        	layer.msg("请输入内容");
            return;
		}
//		$.ajax({
//			type:'post',
//			url:'',
//			data:{},
//			success:function(res){},
//			error:function(res){}
//		});
	}
	//评论列表
	$scope.commentquery=function(){
		
	}
    ///登录弹窗
    $scope.login=function(){
        layer.closeAll();
        $scope.signupShow=false;
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
        //
        var param1=$scope.email;
        var param2=$scope.password;
        if(param1==undefined || param1==null||param2==undefined||param2==null){
            layer.closeAll();
            layer.alert("账户密码输入异常");
            return ;
        }
        $.ajax({
            type:'post',
            url:'/yuyin/login',
            data:{"email":param1,"password":param2},
            success:function(res){
                if(res==200){
                    layer.closeAll();
                    location.reload();
                }else if(res==404){
                    layer.alert("用户不存在");
                }
                else if(res==400){
                    layer.alert("密码错误");
                }
            },
            error:function(){
                layer.alert("异常");
            }
        })
    }
    //退出按钮
    $scope.logout=function(){
        $.ajax({
            type:'post',
            url:'',
            success:function(res){
                if(res=200){
                    $.cookie("userId",null, { path: "/"})
                    $.cookie("userName",null, { path: "/"})
                    $.cookie("headImage",null, { path: "/"})
                    location.reload();
                }
            }
        })
    }
    //注册弹窗
    $scope.signup=function(){
        layer.closeAll();
        $scope.loginshow=false;
        $scope.signupShow=true;
        layer.open({
            type: 1,
            title:'注册',
            offset: '100px',
            content: $('#signupContent'),
            cancel:function(){
                $scope.signupShow=false;
                $scope.$apply();
            }
        });
    }
    //注册按钮
    $scope.register=function(){
        var param1=$scope.email;
        var param2=$scope.password;
        var param3=$scope.nickname;
        if(param1==undefined || param1==null||param2==undefined||param2==null||param3==undefined||param3==null){
            layer.closeAll();
            layer.alert("账户密码输入异常");
            return ;
        }
        $.ajax({
            type:'post',
            url:'/yuyin/register',
            data:{"email":param1,"password":param2,"nickname":param3},
            success:function(res){
                if(res==200){
                    layer.closeAll();
                    location.reload();
                }
                else if(res==400){
                    layer.alert("用户已存在");
                }
            },
            error:function(){
                layer.alert("异常");
            }
        })
    }
	function init(){
		$scope.query();
		$scope.commentquery();
        if(userId==null||userId==undefined||userId=="null"){
            $scope.loginStatus=1;
        }else{
            $scope.loginStatus=2;
            $scope.userName=userName;
            $scope.headImage=headImage;
            $scope.userId=userId;
        }
	}
	init();
	if(playlist.length>0){
	// Settings
	var repeat = localStorage.repeat || 0,track,
		shuffle = localStorage.shuffle || 'false',
		continous = true,
		autoplay = true;
		//console.log(playlist);
	// Load playlist
	for (var i=0; i<playlist.length; i++){
		var item = playlist[i];
		$('#playlist').append('<li>'+item.musicname+' - '+item.singer+'</li>');
	}

	var time = new Date(),
		currentTrack = shuffle === 'true' ? time.getTime() % playlist.length : 0,
		trigger = false,
		audio, timeout, isPlaying, playCounts;

	var play = function(){
		audio.play();
		$('.playback').addClass('playing');
		timeout = setInterval(updateProgress, 500);
		isPlaying = true;
	}

	var pause = function(){
		audio.pause();
		$('.playback').removeClass('playing');
		clearInterval(updateProgress);
		isPlaying = false;
	}

	// Update progress
	var setProgress = function(value){
		var currentSec = parseInt(value%60) < 10 ? '0' + parseInt(value%60) : parseInt(value%60),
			ratio = value / audio.duration * 100;

		$('.timer').html(parseInt(value/60)+':'+currentSec);
		$('.progress .pace').css('width', ratio + '%');
		$('.progress .slider a').css('left', ratio + '%');
	}

	var updateProgress = function(){
		setProgress(audio.currentTime);
	}

	// Progress slider
	$('.progress .slider').slider({step: 0.1, slide: function(event, ui){
		$(this).addClass('enable');
		setProgress(audio.duration * ui.value / 100);
		clearInterval(timeout);
	}, stop: function(event, ui){
		audio.currentTime = audio.duration * ui.value / 100;
		$(this).removeClass('enable');
		timeout = setInterval(updateProgress, 500);
	}});

	// Volume slider
	var setVolume = function(value){
		audio.volume = localStorage.volume = value;
		$('.volume .pace').css('width', value * 100 + '%');
		$('.volume .slider a').css('left', value * 100 + '%');
	}

	var volume = localStorage.volume || 0.5;
	$('.volume .slider').slider({max: 1, min: 0, step: 0.01, value: volume, slide: function(event, ui){
		setVolume(ui.value);
		$(this).addClass('enable');
		$('.mute').removeClass('enable');
	}, stop: function(){
		$(this).removeClass('enable');
	}}).children('.pace').css('width', volume * 100 + '%');

	$('.mute').click(function(){
		if ($(this).hasClass('enable')){
			setVolume($(this).data('volume'));
			$(this).removeClass('enable');
		} else {
			$(this).data('volume', audio.volume).addClass('enable');
			setVolume(0);
		}
	});

	// Switch track
	var switchTrack = function(i){
		if (i < 0){
			track = currentTrack = playlist.length - 1;
		} else if (i >= playlist.length){
			track = currentTrack = 0;
		} else {
			track = i;
		}

		$('audio').remove();
		loadMusic(track);
		if (isPlaying == true) play();
	}

	// Shuffle
	var shufflePlay = function(){
		var time = new Date(),
			lastTrack = currentTrack;
		currentTrack = time.getTime() % playlist.length;
		if (lastTrack == currentTrack) ++currentTrack;
		switchTrack(currentTrack);
	}

	// Fire when track ended
	var ended = function(){
		pause();
		audio.currentTime = 0;
		playCounts++;
		if (continous == true) isPlaying = true;
		if (repeat == 1){
			play();
		} else {
			if (shuffle === 'true'){
				shufflePlay();
			} else {
				if (repeat == 2){
					switchTrack(++currentTrack);
				} else {
					if (currentTrack < playlist.length) switchTrack(++currentTrack);
				}
			}
		}
	}

	var beforeLoad = function(){
		var endVal = this.seekable && this.seekable.length ? this.seekable.end(0) : 0;
		$('.progress .loaded').css('width', (100 / (this.duration || 1) * endVal) +'%');
	}

	// Fire when track loaded completely
	var afterLoad = function(){
		if (autoplay == true) play();
	}

	// Load track
	var loadMusic = function(i){
		var item = playlist[i],
			newaudio = $('<audio>').html('<source src="'+item.musicpath+'"><source src="'+item.ogg+'">').appendTo('#player');
		
		$('.cover').html('<img src="'+item.musicimage+'" alt="'+item.album+'">');
		$('.tag').html('<strong>'+item.musicname+'</strong><span class="artist">'+item.singer+'</span><span class="album">'+item.album+'</span>');
		$('#playlist li').removeClass('playing').eq(i).addClass('playing');
		audio = newaudio[0];
		audio.volume = $('.mute').hasClass('enable') ? 0 : volume;
		audio.addEventListener('progress', beforeLoad, false);
		audio.addEventListener('durationchange', beforeLoad, false);
		audio.addEventListener('canplay', afterLoad, false);
		audio.addEventListener('ended', ended, false);
	}

	loadMusic(currentTrack);
	$('.playback').on('click', function(){
		if ($(this).hasClass('playing')){
			pause();
		} else {
			play();
		}
	});
	$('.rewind').on('click', function(){
		if (shuffle === 'true'){
			shufflePlay();
		} else {
			switchTrack(--currentTrack);
		}
	});
	$('.fastforward').on('click', function(){
		if (shuffle === 'true'){
			shufflePlay();
		} else {
			switchTrack(++currentTrack);
		}
	});
	$('#playlist li').each(function(i){
		var _i = i;
		$(this).on('click', function(){
			switchTrack(_i);
		});
	});

	if (shuffle === 'true') $('.shuffle').addClass('enable');
	if (repeat == 1){
		$('.repeat').addClass('once');
	} else if (repeat == 2){
		$('.repeat').addClass('all');
	}

	$('.repeat').on('click', function(){
		if ($(this).hasClass('once')){
			repeat = localStorage.repeat = 2;
			$(this).removeClass('once').addClass('all');
		} else if ($(this).hasClass('all')){
			repeat = localStorage.repeat = 0;
			$(this).removeClass('all');
		} else {
			repeat = localStorage.repeat = 1;
			$(this).addClass('once');
		}
	});

	$('.shuffle').on('click', function(){
		if ($(this).hasClass('enable')){
			shuffle = localStorage.shuffle = 'false';
			$(this).removeClass('enable');
		} else {
			shuffle = localStorage.shuffle = 'true';
			$(this).addClass('enable');
		}
	});
	}
})
