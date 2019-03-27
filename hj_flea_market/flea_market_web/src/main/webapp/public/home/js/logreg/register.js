$(function() {
	var required = 0;
	initChosen();
	$("#verifycode").click(function() {
		var verifyURL = '/Verify/verifycode';
		$("#verifycode").attr("src", verifyURL + '?' + Math.random());
	});
	$(".emailcode")
			.click(
					function() {
						if ($("#email").val() == '') {
							layer.msg('邮箱不能为空');
							return;
						} else {
							var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
							if (!myreg.test($("#email").val())) {
								layer.msg('邮箱不正确');
								return false;
							} else {
								senEamilCode();
							}
						}
					});
	$("#js-submit")
			.click(
					function() {
						if (required == 1) {
							return false;
						}
						if ($("#username").val() == '') {
							layer.msg('账号不能为空');
							return;
						}
						if ($("#password").val() == '') {
							layer.msg('密码不能为空');
							return;
						}
						if ($("#surepassword").val() == '') {
							layer.msg('确认密码不能为空');
							return;
						}
						if ($("#surepassword").val() != $("#password").val()) {
							layer.msg('密码、确认密码不一致');
							return;
						}
						if ($("#email").val() == '') {
							layer.msg('邮箱不能为空');
							return;
						} else {
							var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
							if (!myreg.test($("#email").val())) {
								layer.msg('邮箱不正确');
								return false;
							}
						}
						if ($("#passcode").val() == '') {
							layer.msg('验证码不能为空');
							return;
						}
						required = 1;
						var data = {};
						data.userName = $("#username").val();
						data.userPassword = $("#password").val();
						data.surePassword = $("#surepassword").val();
						data.userEmail = $("#email").val();
						data.userEmailCode = $("#passcode").val();
						$.ajax({
							url : "/hj_flea_market/regist",
							type : "post",
							data : JSON.stringify(data),
							contentType : "application/json; charset=utf-8",
							success : function(result) {
								required = 0;
								if (result.retCode == 0) {
									layer.msg("注册成功，即将跳转到登录界面");
									setTimeout(function() {location.href = "/hj_flea_market/loginPage";}, 600);
									} else {
										layer.msg(result.retMsg);
									}
							}
						});

					});
});
/**
 * 初始化chosen表单
 */
function initChosen() {
	var config = {
		'.chosen-select' : {},
		'.chosen-select-deselect' : {
			allow_single_deselect : true
		},
		'.chosen-select-no-single' : {
			disable_search_threshold : 10
		},
		'.chosen-select-no-results' : {
			no_results_text : '找不到搜索结果'
		},
		'.chosen-select-width' : {
			width : "95%"
		}
	}
	for ( var selector in config) {
		$(selector).chosen(config[selector]);
	}
}

// 发送验证码倒计时60s
/*
 * $(function() {
 * 
 * var btn = $(".emailcode"); $(function() { btn.click(settime); }) var
 * countdown = 60;//倒计时总时间，为了演示效果，设为5秒，一般都是60s function settime() { if
 * (countdown == 0) { btn.attr("disabled", false); btn.html("获取验证码");
 * btn.removeClass("disabled"); countdown = 60; return; } else {
 * btn.addClass("disabled"); btn.attr("disabled", true); btn.html("重新发送(" +
 * countdown + ")"); countdown--; } setTimeout(settime, 1000); } })
 */
var countdown = 60;// 倒计时总时间，为了演示效果，设为5秒，一般都是60s

function settime() {
	var btn = $(".emailcode");
	if (countdown == 0) {
		btn.attr("disabled", false);
		btn.html("获取验证码");
		btn.removeClass("disabled");
		countdown = 60;
		return;
	} else {
		btn.addClass("disabled");
		btn.attr("disabled", true);
		btn.html("重新发送(" + countdown + ")");
		countdown--;
	}
	setTimeout(settime, 1000);
}

function senEamilCode() {
	settime();
	var data = {};
	data.userEmail = $("#email").val();
	$.ajax({
		url : "/hj_flea_market/email",
		type : "post",
		dataType : "json",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			if (result.retCode == 0) {
				layer.msg("发送成功，请到邮箱查看");
			} else {
				layer.msg("发送失败请重试！");
			}

		}
	});
}
