$(document).ready(function () {
    var required = 0;
    initChosen();

    $("#verifycode").click(function () {
        var verifyURL = '/Verify/verifycode';
        $("#verifycode").attr("src",verifyURL+'?'+Math.random());
    })

    $("#js-submit").click(function () {
        if(required == 1) {
            return false;
        }
        if($("#username").val() == '') {
            layer.msg('账号不能为空');
            return;
        }
        if($("#password").val() == '') {
            layer.msg('密码不能为空');
            return;
        }
        if($("#email").val() == '') {
            layer.msg('邮箱不能为空');
            return;
        } else {
            var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
            if(!myreg.test($("#email").val()))
            {
                layer.msg('邮箱不正确');
                return false;
            }
        }
        if($("#passcode").val() == '') {
            layer.msg('验证码不能为空');
            return;
        }
        required = 1;
        $("#js-form").ajaxSubmit(function(res) {
            required = 0;
            if(res.status == 1) {
                layer.msg(res.msg);
                setTimeout(function() {
                    location.href = res.url;
                }, 600);
            } else {
                layer.msg(res.msg);
            }
        });
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

