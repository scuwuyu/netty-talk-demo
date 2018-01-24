<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="expires" content="0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <script type="text/javascript">
        ;(function (win,doc) {
            var metaEl;
            function setViewport() {
                var psdWidth = 640;
                var metaContent = ['width='+psdWidth,'user-scalable=no'];
                var sw;
                var ua = navigator.userAgent;
                var match = ua.match(/Android (\d+\.\d+)/);
                var scale;
                if (match && ua.match(/MicroMessenger/i) !="MicroMessenger" && !ua.match(/Sogou/i)){
                    sw = win.screen.width;
                }else{
                    sw = (!win.orientation || win.orientation == 0 || win.orientation == 180 )?win.screen.width:win.screen.height;
                }
                scale = sw / psdWidth;
                metaContent.push('minimum-scale=' + scale);
                metaContent.push('maximum-scale=' + scale);
                if (match){
                    if(ua.match(/Sogou/)){ //安卓搜狗浏览器
                        metaContent.push('target-densitydpi='+psdWidth/sw*win.devicePixelRatio*160) 
                    }else{
                        metaContent.push('target-densitydpi=device-dpi');
                    }
                }
                metaEl = metaEl || doc.createElement('meta');
                metaEl.setAttribute('name', 'viewport');
                metaEl.setAttribute('content',metaContent.join(','));
                doc.documentElement.firstElementChild.appendChild(metaEl);
            //    alert(win.screen.width);
            }
            setViewport();
            win.addEventListener("onorientationchange" in win ? "orientationchange" : "resize", setViewport, false);
        })(window,document);
    </script>
<!--<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1,user-scalable=no">-->
    <meta name="format-detection" content="telephone=no">
    <title>404 - 电子券</title>
    <script type="text/javascript">
        var baseUrl = {   
            path:'',   //全局路径配置
            imgPath:''  //全局图片路径配置
        }
    </script>
    <link rel="stylesheet" type="text/css" href="${mobile_static_base}/asset/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="${mobile_static_base}/asset/css/common.css" />
    <script src="${mobile_static_base}/asset/js/require.js" defer async data-main="${mobile_static_base}/asset/js/error"></script>  <!-- 页面样式 不同模块不同js加载器路径 -->
</head>

<body class="">
    <!-- 页头 start -->
    <header class="page-header">
        <a class="icon-arrow-left back-to" href="javascript:;"></a>
        <h1>X_卡</h1>
        <a class="btn-right" href="/xpackage">我的X卡</a>
    </header>
    <!-- 页头 end -->
    <!-- 内容 start -->
	<section class="main">
        <div class="error-page noFoundPage">
            <h2>您访问的页面不存在，请返回重试</h2>
            <p>Page not found,back to home</p>
        </div>
    </section>
    <!-- 内容 end -->
    <!-- 页尾 start -->
    <footer>
    </footer>
    <!-- 页尾 end -->
</body>
</html>