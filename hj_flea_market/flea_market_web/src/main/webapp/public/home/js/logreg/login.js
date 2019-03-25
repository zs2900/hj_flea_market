$(function() {
	$("#verifycode").click(function () {
	    var verifyURL = '/hj_flea_market/verifycode';
	    $("#verifycode").attr("src",verifyURL+'?'+Math.random());
	})
	
	$('.i-checks').iCheck({
	    checkboxClass: 'icheckbox_square-green',
	    radioClass: 'iradio_square-green',
	});
	
	$('input[type="checkbox"]').on('ifChecked', function(event){
		rememberPwd();
		});

	$("#js-submit").click(function () {
		if($("#username").val() == '') {
			layer.msg('账号不能为空');
			return;
		}
		if($("#password").val() == '') {
			layer.msg('密码不能为空');
			return;
		}
		if($("#passcode").val() == '') {
			layer.msg('验证码不能为空');
			return;
		}
        /*$("#js-form").ajaxSubmit(function(res) {
        	if(res.status == 1) {
        		layer.msg(res.msg);
        		setTimeout(function() {
        			location.href = res.url;
        		}, 600);
        	} else {
        		layer.msg(res.msg);
        	}
        });*/

			var username = $("#username").val();
			var userpassword = $("#password").val();
			var passcode = $("#passcode").val();
			var data = {"userEmail" : username,"userPWD" : userpassword,"userImgCode" : passcode};
			$.ajax({
				type: 'post', // 提交方式 get/post
				url: '/hj_flea_market/login', // 需要提交的 url
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				success: function(result) {
					// 此处可对 data 作相关处理
					if(result.retCode == 0){
						layer.msg(result.retMsg);
		        		setTimeout(function() {
		        			location.href = "/hj_flea_market/sale";
		        		}, 600);
					}else{
						layer.msg(result.retMsg);
					}
				}
			});
    });
})

//记住密码
function rememberPwd(){
        //cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
        var conFlag = confirm("记录密码功能不宜在公共场所(如网吧等)使用,以防密码泄露.您确定要使用此功能吗?");
        if(conFlag){ //确认标志
            var username = $("input[id='username']").val();
            var password = $("input[id='password']").val();
            setCookie("username",username,20);
            setCookie("password",password,20);
        }else{
            $("input[type='checkbox']").removeAttr('checked');
        }
}
