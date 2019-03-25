/**
 * 查询数据，由点击排序部分触发
 * @param dom obj 被点击的对象
 * @param int target 用户区别被点击的对象，0-随机，1-时间，2-价格，3-热度
 */
function queryBuy(obj, target){
    _this = $(obj);
    var url = '/home/buy/queryBuy';
    if(target == 0){//热度
        order = 0;
    }
    if(target == 1){//时间
        order = $.trim(_this.attr("data-type"))==5?6:5;//取和上一次相反的升降序
    }
    if(target == 2){//价格
        order = $.trim(_this.attr("data-type"))==1?2:1;//取和上一次相反的升降序
    }
    if(target == 3){//热度
        order = $.trim(_this.attr("data-type"))==3?4:3;//取和上一次相反的升降序
    }
    url = url + "/order/" + order;
    var keyword = $.trim($("input[name='keyWord']").val());
    if(keyword){
        url = url + "/keyword/" + keyword;
    }
    var type = $.trim($("input[name='type']").val());
    if(type){
        url = url + "/type/" + type;
    }
    //console.log(order)
    location.href = url;
}

$(function(){
    //返回顶部的那个小按钮的js
    $('.toTop').hide();
    $(window).scroll(function() {
        if($(window).scrollTop() >= 100){
            $('.toTop').fadeIn(1000);
        }
        else{
            $('.toTop').fadeOut(1000);
        }
    });
    $('.toTop').click(function(){
        $('body,html').animate({scrollTop:0},1000,'swing');
    })

    // swiper轮播图
    var mySwiper = new Swiper ('.swiper-container', {
        loop: true,
        pagination: '.swiper-pagination',
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        effect: 'fade',
        loop: true,
        autoplay: 3000,
        speed: 1000,
        autoplayDisableOnInteraction: false,
        lazyLoading : true,
        lazyLoadingOnTransitionStart : true,
        lazyLoadingInPrevNextAmount : 2,
        lazyLoadingInPrevNext : true,
    })

    // 图片lazyload懒加载
    $("img.lazyload").show().lazyload({
        threshold : 100,
        placeholder : "/public/images/icon/small_loading_default.png",
        effect : "fadeIn" ,
        effectspeed : 500,
        failure_limit : 10,
    });
})

/**
 * 求购页关键字搜索
 */
function toSearch(){
    var keyword = $("#serachWord").val();
    var url = "/buy/queryBuy/keyword/" + keyword;
    location.href = url ;
}
