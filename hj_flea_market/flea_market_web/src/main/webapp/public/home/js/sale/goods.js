function querySale(sType, target) {
	
	/*var type = $.trim($("input[name='type']").val());
	if (type) {
		url = url + "/type/" + type;
	}
	location.href = url;*/
}

function querySaleByType(type){
	var param = {};
	if(type){
		param.gType = type;
	}
	$("input[name='type']").attr("value", type);
	findGoods(param);
	return false;
}

function sortSale(obj, target){
	_this = $(obj);
	var param = {};
	var order = 0;
	if (target == 0) {//随机
	}
	if (target == 1) {//按时间
		param.sortByTime = $.trim(_this.attr("data-type")) == 0 ? 1 : 0;//
		_this.attr("data-type", param.sortByTime);
	}
	if (target == 2) {//按价格
		param.sortByPrice = $.trim(_this.attr("data-type")) == 0 ? 1 : 0;//
		_this.attr("data-type", param.sortByPrice);
	}
	if (target == 3) {//按热度
		/*order = $.trim(_this.attr("data-type")) == 0 ? 1 : 0;//
		_this.attr("data-type", order);*/
	}
	var keyword = $.trim($("input[name='keyword']").val());
	if (keyword) {
		param.gName = keyword;
	}
	var type = $.trim($("input[name='type']").val());
	if(type){
		if(type != 0){
			param.gType = type;
		}
	}
	findGoods(param);
}

$(function() {
	updatelogin();
	initSales();
	initDisplay();
	if (!getCookie('margin')) {
		resetMargin();
	}

	
	$(window).resize(function() {
		resetMargin(); 
	});

	
	$('.toTop').hide();
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 100) {
			$('.toTop').fadeIn(1000);
		} else {
			$('.toTop').fadeOut(1000);
		}
	});
	$('.toTop').click(function() {
		$('body,html').animate({
			scrollTop : 0
		}, 1000, 'swing');
	})
})

/**
 * 初始化swiper
 */
function initSwiper(){
	var mySwiper = new Swiper('.swiper-container', {
		loop : true,
		pagination : '.swiper-pagination',
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev',
		effect : 'fade',
		loop : true,
		autoplay : 3000,
		speed : 1000,
		autoplayDisableOnInteraction : false,
		observer:true,//修改swiper自己或子元素时，自动初始化swiper
	    observeParents:true,//修改swiper的父元素时，自动初始化swiper
		lazyLoading : true,
		lazyLoadingOnTransitionStart : true,
		lazyLoadingInPrevNextAmount : 2,
		lazyLoadingInPrevNext : true,
	});
	$("img .lazyload").show().lazyload({
		threshold : 100,
		placeholder : "public/images/icon/small_loading_default.png",
		effect : "fadeIn",
		effectspeed : 500,
		failure_limit : 10,
	});
}
/**
 * 初始化商品列表
 */
function initSales(){
	var param = {};
	findGoods(param);
}

function initParam(param){
	param.pageSize = 24;
	param.offset = 0;
}

function findGoods(param){
	var data = {};
	if(!(typeof param == "undefined" || param == null || param == "")){
		data = param;
	}
	initParam(data);
	$.ajax({
		type: "post",
		url: "/hj_flea_market/selectGoodsNum",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				$(".pagination").pagination({
					 pageCount:result.pageSize,
	                 coping:true,
	                 isHide:true,
	                 homePage:'首页',
	                 endPage:'末页',
	                 prevContent:'上页',
	                 nextContent:'下页',
	                 current:1,
	                 callback: function(api){
	                	 data.offset=(api.getCurrent() - 1) * 24;
	                	 PageCallback(data);
	                 }	 
				});
				PageCallback(data);
			}else {
				layer.msg(result.retMsg);
			}
			
		}
	});
}

function PageCallback(data){
	 $.ajax({
		 type: "post",
		 url: "/hj_flea_market/selectGoodsList",
		 data: JSON.stringify(data),
		 contentType: "application/json; charset=utf-8",
		 success: function(result){
			if(result.retCode == 0){
				$(".goodsbox").html("");
				for(var i = 0; i < result.goodsList.length; i++){
					var obj = result.goodsList[i];
					var ss = '<li class="items clearfix" style="margin-left: 39.142857142857146px;">';
					ss += '<div class="class-item"><div class="class-bg-layer"></div>';
					ss += '<div class="class-item-bg"> <a target="_blank" href="/hj_flea_market/goods?gId='+ obj.gId +'" class="class-img">';
					ss += '<img class="img-responsive lazyload" src="' + obj.pictures[0].pUrl + '" alt="'+ obj.gName +'" data-original="uploads/salebuy/2019-03-07/5c80d801426ca.png"> </a>';
					ss += '<div class="pricehot clearfix"> <span class="price">￥&nbsp;<span>'+ obj.gPrice +'</span></span> <span class="hot">点击数&nbsp;<span>'+ obj.clickNum +'</span></span> </div>';
					ss += '<a target="_blank" href="/hj_flea_market/goods?gId='+ obj.gId +'" class="title"> '+ obj.gName +' </a>';
					ss += '<div class="some  clearfix"> <span class="school">广西师范大学</span> <span class="renzheng">未认证 </span>';
					ss += '</div> </div> </div> </li>';
					$(".goodsbox").append(ss);
				}
			}else {
				layer.msg(result.retMsg);
			}
		 },
		 error: function(){
			 layer.msg("未知错误");
		 }
	 });
}

/**
 * 重新设置margin
 */
function resetMargin() {
	var width = $(".goodsbox").width();
	var old_margin = 30;
	for (var i = 4; i <= 8; i++) {
		var margin = width - ((i + 1) * 25) - i * 220;
		if (margin < 250) {
			var less = (width - (i * 220)) / (i + 1);
			setCookie('margin', less, 3600);
			setCookie('pagenum', i * 4, 3600);
			$(".goodsbox .items").css('margin-left', less + 'px');
			$(".banner, .outer-school").css('padding-left', less + 'px');
			$(".banner, .outer-school").css('padding-right', less + 'px');
			break;
		}
	}
}

/**
 * 查询商品
 */
function toSearch() {
	var keyword = $("#serachWord").val();
	var param = {};
	if(keyword){
		param.gName = keyword;
	}
	findGoods(param);
}

function initDisplay(){
	var data = {};
	data.dState = 0;
	$.ajax({
		url: "/hj_flea_market/displaylist",
		type: "post",
		dataType: "json",
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				var ss = "";
				$.each(result.displays, function(i,obj){
					ss += '<div class="swiper-slide"><a target="_blank" href="/hj_flea_market/goods?gId='+obj.gId+'">'
					   + '<img src="'+result.imageRoot + obj.dImg+'" class="swiper-lazy"></a>'
					   + '<div class="swiper-lazy-preloader"></div></div>';
				});
				$(".swiper-wrapper").html(ss);
				initSwiper();
			}else {
				layer.msg(result.retMsg, {icon : 5});
			}
		}
	});
}