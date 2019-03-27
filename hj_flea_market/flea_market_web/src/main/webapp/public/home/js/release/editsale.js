$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"
});


$().ready(function () {
	updatelogin();
    initChosen();
    var requiring = 0;
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#saleForm").validate({
        submitHandler: function() {
            if(requiring == 1) return ;
            requiring = 1;
            $("#saleForm").ajaxSubmit(function(res) {
                requiring = 0;
                if(res.status == 1) {
                    layer.msg(res.msg);
                    setTimeout(function() {
                        location.href = res.url;
                    }, 600);
                } else {
                    layer.msg(res.msg);
                }
            });
        },
        rules: {
            title: {
                required: true,
                minlength: 5
            },
            detail: {
                required: true,
                minlength: 10
            },
            address: "required",
            price: {
                required: true,
                digits: true
            },
            school: "required",
            type: "required",
            tel: "digits",
            qq: "digits",
        },
        messages: {
            title: {
                required: icon + "请填写标题",
                minlength: icon + "标题不能少于{0}个字符"
            },
            detail:  {
                required: icon + "请填写详情",
                minlength: icon + "详情不能少于{0}个字符"
            },
            address: {
                required: icon + "请输入交易地点",
            },
            price: {
                required: icon + "请输期望价格",
                digits: icon + "价格只能是数字",
            },
            tel: {
                digits: icon + "手机号只能是数字",
            },
            qq: {
                digits: icon + "QQ号只能是数字",
            },
        }
    });
});

/**
 * 初始化chosen表单
 */
function initChosen() {
    var config = {
        '.chosen-select': {},
        '.chosen-select-deselect': {
            allow_single_deselect: true
        },
        '.chosen-select-no-single': {
            disable_search_threshold: 10
        },
        '.chosen-select-no-results': {
            no_results_text: '找不到搜索结果'
        },
        '.chosen-select-width': {
            width: "95%"
        }
    }
    for (var selector in config) {
        $(selector).chosen(config[selector]);
    }
}

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function submitEditSaleInfo(){
	$.ajax({
		type: "post",
		url: "/hj_flea_market/editSaleInfo",
		data:JSON.stringify($("#editsaleForm").serializeObject()),
	    contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
	    success: function(result){
	    	if(result.retCode == 0){
	    		var index = parent.layer.getFrameIndex(window.name);
	    		parent.layer.msg("编辑成功");
	    		//parent.layer.close(index);
	    		setTimeout(function(){layer.close(layer.index);}, 1000);
	            setTimeout(function(){parent.location.reload();}, 1000);
	    	}else{
	    		layer.msg(result.retMsg);
	    	}
	    }
	});
	 
}