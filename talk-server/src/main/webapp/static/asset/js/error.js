/*	@description: 电子券核销一期  错误页
*	@author: wuxiaoxia    
*	@update: wuxiaoxia   (2015-06-29) */

//配置require文件  start
require.config({
    baseUrl: baseUrl.path+'/asset/js/lib', 
    paths: {  //引入js文件路径配置
        'jquery': 'jquery-1.8.3.min',
		'common':'common',
        'iscroll':'iscroll'
    },
//  enforceDefine:true,
    shim: {   
        'common': {
            deps: ['jquery'],
            exports: 'common'
        },
        'iscroll':{
            exports: 'iscroll'
        }
    },
    urlArgs: "t=" + (new Date()).getTime()
});
//配置require文件 end

require(['jquery','common','iscroll'], function ($){

    var winResizeFlag;
    var winResize = function(){
        if(winResizeFlag)clearTimeout(winResizeFlag);
        winResizeFlag = setTimeout(function(){
           $('.main').css('height',$(window).height()*640/$(window).width()-$('.page-header').height());  //设置main的高度
            if(Iscroll){
                Iscroll.refresh();
            }
        },100);
    }
    winResize();
    
});
