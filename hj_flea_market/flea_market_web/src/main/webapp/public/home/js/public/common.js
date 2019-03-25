$(function(){
	// 实例化顶部的导航菜单背景随鼠标移动效果
    $("#js-nav-slide, #js-login-slid").lavaLampTop({
        fx: "backout",
        speed: 700,
        click: function(event, menuItem) {
            return true;
        }
    });
    // 实例化左边的导航菜单背景随鼠标移动效果
    $("#js-sale-item").lavaLampLeft({
        fx: "backout",
        speed: 700,
        click: function(event, menuItem) {
            return true;
        }
    });

    // 全局右边组件滚动已帮助数字
    $("#js-numberrock").numberRock({
	    speed:25,
	    count: numberRock
	})

    /**
     * 个人中心头部的全局js
     */
    /*鼠标移过头像是显示出更换头像的hover图遮罩*/
    $('#origin_ph').mouseover(function(){
        $('#change_ph').show();
    })
    $('#change_ph').mouseout(function(){
        $('#change_ph').hide();
    })
    // 实例化顶部的导航菜单背景随鼠标移动效果
    $("#middle_nav").lavaLampTop({
        fx: "backout",
        speed: 700,
        click: function(event, menuItem) {
            return true;
        }
    });

});

/**
 * 获取url中的参数
 * 
 * @returns {Object}
 */
function getRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}

/**
 * 设置cookie
 * @param str name cookie名称
 * @param str value cookie的值
 * @param str day cookie保存的天数
 */
function setCookie(name, value, day) {
    var oDate = new Date();  
    oDate.setDate(oDate.getDate() + day);  
    document.cookie = name + '=' + value + ';expires=' + oDate + ';path=/';  
}

//删除cookie  
function delCookie(name) {  
    setCookie(name, 1, -1);  
}  
  
//获取cookie  
function getCookie(name) {  
    var arr = document.cookie.split('; ');  
    for(var i = 0; i < arr.length; i++) {  
        var arrName = arr[i].split('=');  
        if(arrName[0] == name) {  
            return arrName[1];  
        }  
    }  
    return '';  
} 

function getMyDate(str){  
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
    return oTime;  
};  
//补0操作  
function getzf(num){  
    if(parseInt(num) < 10){  
        num = '0'+num;  
    }  
    return num;  
}

/**
 * 登录状态
 */
function updatelogin() {
	var data = {};
	$.ajax({
		type : "post",
		url : "/hj_flea_market/findUser",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			if (result.retCode == 0) {
				showLogin(true, result);
				/*$.cookie("headpicPath",result.headPic,{ expires: 7, path: '/hj_flea_market/' });*/
			} else {
				showLogin(false);
				layer.msg(result.retMsg);
			}
		}
	});

}

/**
 * 显示用户登录
 */
function showLogin(isLogin, obj) {
	if (isLogin) {
		$("#showLogin li").eq(0).html('<a class="headpic-link" target="_blank" href="/hj_flea_market/user">'
                 +'<img class="headpic" class="img-responsive center-block" src="'+obj.headPic+'">'
                 +'</a>');
		$("#showLogin li").eq(1).html('<a href="/hj_flea_market/loginout">退出</a>');
	} else {
		$("#showLogin li").eq(0).html('<a href="/hj_flea_market/loginPage">登陆</a>');
		$("#showLogin li").eq(1).html('<a href="/hj_flea_market/registerPage">注册</a>');
	}
}
