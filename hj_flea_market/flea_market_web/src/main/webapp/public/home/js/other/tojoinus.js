$(function() {
	// 实例化i-checks的美化选择radio
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
})

// 提交表单使用jquery.form.js，提交之前先验证是否填写完整
function submit_form() {
	var name = $('input[name="name"]').val();
	var school = $('input[name="school"]').val();
	var contactnum = $('input[name="contactnum"]').val();
	if (name == "") {
		layer.msg('请填写您的姓名');
		return ;
	}
	if (school == "") {
		layer.msg('请填写您的学校');
		return ;
	}
	if (contactnum == "") {
		layer.msg('请填写您的联系方式');
		return ;
	}

	// ajax提交表单内容
	$("#js-form").ajaxSubmit(function(res) {
    	if(res.status == 1) {
    		layer.msg(res.msg);
    		setTimeout(function() {
    			location.href = res.url;
    		}, 600);
    	} else {
    		layer.msg(res.msg);
    	}
    });
}