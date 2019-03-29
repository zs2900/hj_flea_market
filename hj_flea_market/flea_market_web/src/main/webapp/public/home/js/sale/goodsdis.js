$(document).ready(function(){
	findGoodsDetial();
    //鼠标经过4个小图中的一个切换大图
    $('.smallpic img').click(function(){
        $('.bigpic img').removeClass('show').addClass('hidden');
        $('.bigpic img').eq($(this).index()).removeClass('hidden').addClass('show');
    });

    // 如果没有screenWidth这个cookie，那么是第一次进来，重算商品边距
    if(!getCookie('recom_num')) {
        resetMargin(); // 重新计算商品的边距
    }

    // 窗口发生改变时重新计算每个商品的左边距
    // 用于二手商品列表页面
    $(window).resize(function() {
        resetMargin(); // 重新计算商品的边距
    });
    getSaleReply();
});

function findGoodsDetial(){
	var param = getRequest();
	var data = {"gId" : param.gId};
	$.ajax({
		type: "post",
		url: "/hj_flea_market/goodsDetail",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				$(".con-FangDa-ImgList").html("");
				showGoodsDetail(result);
			}else{
				layer.msg(result.retMsg);
			}
		}
	});
}

function showGoodsDetail(obj){
	var pictures = obj.pictures;
	if(obj.isLogin){
		$("#showLogin li").eq(0).html('<a class="headpic-link" target="_blank" href="/hj_flea_market/user">'
                +'<img class="headpic" class="img-responsive center-block" src="'+ obj.uHeadPic +'">'
                +'</a>');
		$("#showLogin li").eq(1).html('<a href="/hj_flea_market/loginout">退出</a>');
	} else {
		$("#showLogin li").eq(0).html('<a href="/hj_flea_market/loginPage">登陆</a>');
		$("#showLogin li").eq(1).html('<a href="/hj_flea_market/registerPage">注册</a>');
	}
	if(pictures.length > 0){
		$(".magnifyingBegin").prev().attr("alt",obj.gName + "-柚子校园");
		$(".magnifyingBegin").prev().attr("src",pictures[0].pUrl);
		$(".magnifyingShow img").attr("alt",obj.gName + "-柚子校园");
		$(".magnifyingShow img").attr("src",pictures[0].pUrl);
	}
	
	for(var i = 0; i < pictures.length; i++){
		var ss = '<li class="active"><img src="' + pictures[i].pUrl + '" data-bigimg="' + pictures[i].pUrl + '"></li>';
		$(".con-FangDa-ImgList").append(ss);
	}
	$(".info .gId").attr("value",obj.gId);
	$(".info .title span").text(obj.gName);
	$(".info .howmuch").text(obj.gPrice + "元");
	$(".info .daofou").text("");
	$(".info .userName").text(obj.uName);
	if(obj.isLogin){
		$(".info .contact1 .qq").next().html('<span>'+ obj.uQQNumber +'</span>');
		$(".info .contact2 .tel").next().html('<span>'+ obj.uPhoneNumber +'</span>');
		$("#commoncontent").attr("disabled", false);
		$("#commoncontent").attr("value", "");
		$("#commonbtn").attr("uId",obj.uId);
	}else{
		$(".info .contact1 .qq").next().html('<a target="_blank" href="/hj_flea_market/login"><span class="needlogin">点击登录后可查看</span></a>');
		$(".info .contact2 .tel").next().html('<a target="_blank" href="/hj_flea_market/login"><span class="needlogin">点击登录后可查看</span></a>');
		$("#commoncontent").attr("disabled", true);
		$("#commoncontent").attr("value", "您要登录之后才可以评论哦！");
	}
	$(".info .school .text").text(obj.uSchool);
	$(".info .address .text").text(obj.uAddress);
	$(".info .renzheng .text").text("未认证ao");
	$(".info .time .text").text(getMyDate(obj.gUpdateTime));
	$(".info .weChat .text").text("该同学没留下微信号奥");
	$("#user_cmt").text(obj.gDescription);
	$("#fangdajing").magnifying();
}

/**
 * 用于让商品居中的计算方法
 */
function resetMargin() {
    var width = $(".goodsbox").width();
    var recom_num = Math.floor(width / 210);
    setCookie('recom_num', recom_num, 3600);
}

/**
 * 获取商品留言
 */
function getSaleReply(){
	var param = getRequest();
	var data ={};
	data.gId = param.gId;
	data.pageSize = 10;
	data.offset = 0;
	$.ajax({
		type: "post",
		url: "/hj_flea_market/goodsMsg",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				initmessageList(result.messages);
				$(".commonbox .pagination").pagination({
					 pageCount:result.totalPage,
	                 coping:true,
	                 homePage:'首页',
	                 isHide:true,
	                 endPage:'末页',
	                 prevContent:'上页',
	                 nextContent:'下页',
	                 current:1,
	                 callback: function(api){
	                	 data.offset=(api.getCurrent() - 1) * 10;
	                	 $.ajax({
	                		 type: "post",
	                		 url: "/hj_flea_market/goodsMsg",
	                		 data: JSON.stringify(data),
	                		 contentType: "application/json; charset=utf-8",
	                		 success: function(result){
	                			 if(result.retCode == 0){
	                				 initmessageList(result.messages);
	                			 }else{
	                				 layer.msg(result.retMsg);
	                			 }
	                		 }
	                	 });
	                 }	 
				});
			}else{
				layer.msg(result.retMsg);
			}
		}
	});
}

/**
 * 初始化留言列表
 * @param obj 留言列表数据
 */
function initmessageList(obj){
	var ss = "";
	for( var i = 0; i < obj.length; i++){
		ss += '<li class="list-item clearfix"> <div class="head">'
			+ '<img src="'+ obj[i].uHeadPic +'"> </div> <div class="text">'
			+ '<div class="user clearfix">'
			+ '<div class="username">'+ obj[i].uName +'<span class="reply">留言</span></div>'
			+ '<div class="info"> <span class="reply-time">'+ getMyDate(obj[i].mSendTime) +'</span>'
			+ '</div> </div> <p class="detail" style="padding-left: 0; color: rgb(0,160,155); font-size: 20px">'+ obj[i].mContent +'</p>'
			+ '</div> </li>';
	}
	$(".commonbox .reply-list").html(ss);
}

/**
 * 二手模块的对物品进行回复，ajax加载
 * @return 静态添加回复的条目
 * obj.attr('isLogin')==""不存在用户id，意味着没有登录
 */

function saleReplyPost(){
    var loading = layer.load(0,{time: 3*1000});
    var gId = $(".info .gId").attr("value");
    var uId = $("#commonbtn").attr("uId");
    if(!uId){
    	layer.msg('同学，请您登录之后再评论', {icon: 0});
        return ;
    }
    var mContent = $('#commoncontent').val();
    if(mContent==""){
        layer.msg('您不能什么都不写呃！', {icon: 0});
        return ;
    }
    $('#commoncontent').text("");
    var data = {};
        data.gId = gId;
        data.uId = uId;
        data.mContent = mContent;
    $.ajax({
            url: '/hj_flea_market/sendMsg',    //请求的url地址
            dataType: "json",   //返回格式为json
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: JSON.stringify(data),    //参数值
            type: "POST",   //请求方式
            contentType: "application/json; charset=utf-8",
            success: function(result) {
                if(result.retCode == 0){
                    layer.close(loading);
                    layer.msg('评论成功！', {icon: 1});
                    getSaleReply();
                }
                else{
                    layer.msg('评论失败，请重试！', {icon: 0});
                }
            }
        });
}

/**
 * 在评论的页面，单击“展开更多精彩评论”按钮
 * 展开其余的隐藏起来的评论，隐藏评论的原因是
 * 如果有太多评论的话，页面会拉的很长，更多的
 * 评论放在class为other-appraise的元素里面
 */
function spreadAppraise(obj){
    $('.other-appraise').toggle();
    if($('.other-appraise').is(':hidden')){
        $(obj).text('展开更多的精彩评论');
    }
    else{
        $(obj).text('收起更多的精彩评论');
    }
}

/**
 * 在二手模块对一个物品进行收藏
 * @param int id 物品的id
 * @return false-提示失败，true-提示成功
 */
function saleFavor(obj){
    var obj = $(obj);
    var uId = $("#commonbtn").attr("uId");
    if(!uId){
        layer.msg('没登录是无法收藏的哟！', {icon: 0});
        return ;
    }
    var gId = $(".info .gId").attr("value");
    var loading = layer.load(0,{time: 3*1000});
    var data = {};
    data.gId = gId;
    $.ajax({
    	type: "post",
        url: '/hj_flea_market/addToFavorites',    //请求的url地址
        data: JSON.stringify(data),   //参数值
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            layer.close(loading);
            if(result.retCode == 0){
                layer.msg('收藏成功，您可以在个人中心查看您的收藏。', {icon: 1});
            }
            else{
                layer.msg(result.retMsg, {icon: 0});
            }
        }
    });
}
