/*  @description: 电子券核销一期 公共js
*   @author: jiangfeng  
*   @update: jiangfeng (2015-06-29) */

//重写on 的click事件，在支持touch事件的设备上，click将被替换成touchend事件
// ;(function(){
//     var isTouch = ('ontouchend' in document.documentElement) ? 'touchend' : 'click', _on = $.fn.on;
//         $.fn.on = function(){
//             arguments[0] = (arguments[0] === 'click') ? isTouch: arguments[0];
//             return _on.apply(this, arguments); 
//         };
// })();

// if($(window).width() < 320){
//  $("body").css("zoom",0.5); //自适应屏幕
// }else{
//  $("body").css("zoom",$(window).width()/640); //自适应屏幕
// }

//$('.main').css('height',$(window).height()*640/$(window).width()-$('.page-header').height());  //设置main的高度

$('body').removeClass('hide').addClass('show');

$('.back-to').on('click',function(){  //返回
    window.location.href = document.referrer
})


//弹出层构造器
var PopTips = function(set){
    this.config = {
        id:'TipBox',            //弹出层id
        skin:'error',           //弹出层皮肤  error 去色； green 绿色
        delay:5000,             //弹层提示显示时间，5000ms后关闭  0表示不关闭
        windowDom:window,       //载入窗口
        wrapClass:'pop-layer',  //弹出层class
        btn:[                   //按钮ui  数组形式,1-2个
            {
                islink:false,    //是否是链接
                class:'confirm', //确认class
                title:'确定'    //确认按钮名称
            },
            {
                islink:true,     //是链接
                class:'link',        //class
                title:'查看详情',    //按钮名称
                url:'http://www.xkeshi.com'  //islink == true 这个字段必须，链接地址
            }
        ],
        confirmClass:'confirm', //确认class
        hasMask:true,           //是否显示遮罩
        clickMskCancel:true,    //点击遮罩取消
        str:'<p>我是提示信息。</p>',                 //提示内容  需要包含p标签
        beforeShow:null,        //显示时候的回调
        callback:null       //确认关闭后的回调
    }
    $.extend(this.config,set);
    if(PopTips.prototype.DOM) return;
    this.int();
    return this;
}

PopTips.prototype = {
    DOM: null,
    int:function(){  //初始化  加载ui
        var self = this,
            str = [];
        PopTips.prototype.DOM = $('<section id="'+self.config.id+'"></section>');
        if(self.config.hasMask){
            self._mask = $('<div class="mask"></div>');
        }else{
            self._mask = null;
        };

        str.push('<div class="'+self.config.wrapClass+'">');
        str.push('<div class="pop-main pop-'+self.config.skin+'">');
        str.push('<div class="pop-tips">');
        str.push(self.config.str+'</div></div>');
        str.push('<div class="pop-tools">');
        for(var i = 0; i < self.config.btn.length; i++){
            if(self.config.btn[i].islink){
                str.push('<a href="'+self.config.btn[i]['url']+'" class="pop-btn pop-'+self.config.btn[i].class+'">'+self.config.btn[i].title+'</a>');
            }else{
                str.push('<a href="javascript:;" class="pop-btn pop-'+self.config.btn[i].class+'">'+self.config.btn[i].title+'</a>');
            }
        }       
        str.push('</div></div>');
        self._mask.appendTo(PopTips.prototype.DOM);
        PopTips.prototype.DOM.append(str.join(''));
        self._confirm = PopTips.prototype.DOM.find('.pop-'+self.config.confirmClass);
        PopTips.prototype.DOM.appendTo(self.config.windowDom.document.body);
        if(typeof self.config.beforeShow === "function")self.config.beforeShow();
        setTimeout(function(){
            self.show();
            self.event();
        },30)
        return self;
    },
    event:function(){
        var self = this,t;
        if(self.config.delay){
            t = setTimeout( function(){ self.close(); }, self.config.delay);
        }

        if(self.config.clickMskCancel && this._mask){
            self._mask.on('click',function(){
                if(typeof self.config.callback === "function")self.config.callback = null;
                if(t)clearTimeout(t);
                self.close();
            });
        }

        self._confirm.on('click',function(e){
            if(t)clearTimeout(t);
            self.close();
        })

    },
    show:function(){  //显示
        PopTips.prototype.DOM.find('.mask').addClass('m-show');
        PopTips.prototype.DOM.find('.'+this.config.wrapClass).addClass('p-show');
    },
    close:function(){  //关闭
        var self = this;
        PopTips.prototype.DOM.find('.mask').removeClass('m-show');
        PopTips.prototype.DOM.find('.'+self.config.wrapClass).removeClass('p-show');
        // PopTips.prototype.DOM.find('.mask').one("webkitTransitionEnd",function(){
        //     self.destroy();
        //     typeof self.config.callback === "function" && self.config.callback();
        // });
        setTimeout(function(){
            self.destroy();
            typeof self.config.callback === "function" && self.config.callback();
        },400)
    },
    destroy:function(){  //销毁
        this._mask && this._mask.remove();  
        PopTips.prototype.DOM && PopTips.prototype.DOM.remove();   
        PopTips.prototype.DOM = null;
    }


}

jQuery.extend({
    getToken : function(callback){  //获取防止重复提交的token
        $.ajax({
            type: "POST",
            url:'/xuser/json/getToken',
            contentType:"application/json; charset=utf-8",
            data:"{}",
            dataType: 'json',
            success:function(data){
                callback(data);
            }
        })
    }
});

$.ajaxSetup({
    error:function(xhr, status, e){
        if(xhr.status == 401){
            window.location.href = window.location.href;
        }else{
             new PopTips({
                delay:2000,
                btn:[
                    {
                        islink:false,
                        class:'confirm',
                        title:'确定'
                    }
                ],
                str:'<p>十分抱歉，网络异常</p><p>请稍后刷新页面重试</p>'
            })
        }
    }
});