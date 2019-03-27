
$(document).ready(function(){
	initUserInfo();
    //点击编辑，再点击保存
    $("#base_info #edit_info").click(function(){
        $(this).css({
            display: "none"
        })
        $("#base_info #save_info").css({
            display: "block"
        })
        $("#base_info .right_info span").css({
            display: "none"
        })
        $("#base_info .right_info input").css({
            display: "inline"
        })
    });

    $("#save_info").bind('click',function(){
    	var user = {}
    	user.uName = $("#my_info #nickname").val();
    	user.uQQNumber = $("#my_info #qq").val();
    	user.uAddress = $("#my_info #address").val();
    	user.uPhoneNum = $("#my_info #phone").val();
        $.ajax({
            url: '/hj_flea_market/updateUserinfo',
            dataType: "json",
            async: true,
            data: JSON.stringify({"user" : user}),    //参数值
            type: "post",   //请求方式
            contentType: "application/json; charset=utf-8",
            success: function(result) {
                //请求成功时处理
                if(result.retCode == 0){
                    layer.msg('修改成功');
                    $("#save_info").css({
                        display: "none"
                    });
                    $("#edit_info").css({
                        display: "block"
                    });
                    $("#qq_span").text($("#qq").val()),
                    $("#phone_span").text($("#phone").val()),
                    $("#address_span").text($('#address').val()),
                    $(".nickname_span").text($('#nickname').val()),
                    $(".right_info input").css({
                        display: "none"
                    });
                    $("#base_info .right_info span").css({
                        display: "inline"
                    });
                }
                else{
                    layer.msg("修改失败，"+result.retMsg+"！");
                }
            },
        });
    });
})

function initUserInfo(){
	showUserBaseInfo();
	var data = {};
	$.ajax({
		type: "post",
		url: "/hj_flea_market/getUserInfo",
		dataType: "json",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				$(".userHeadPic").attr("src", result.user.uHeadPic);
				$("#user_msg .name").html(result.user.uName);
				$("#user_msg .userSchool").html(result.user.uSchool);
				$("#my_info #accountEmail").html('<span>'+ result.user.uEmail +'</span>');
				$("#my_info #nickname_span").html(result.user.uName);
				$("#my_info #address_span").html(result.user.uAddress);
				$("#my_info #phone_span").html(result.user.uPhoneNum);
				$("#my_info #qq_span").html(result.user.uQQNumber);
			}else {
				layer.msg(result.retMsg);
			}
		}
	});
}

function showUserBaseInfo(){
	$(".item-base li").removeClass("current");
	$("#my_info").show();
	$(".item-info").addClass("current");
	$("#userSale").hide();
	$("#userFavorites").hide();
}

function showUserSale(){
	$(".item-base li").removeClass("current");
	$("#my_info").hide();
	$("#userSale").show();
	$(".item-goods").addClass("current");
	$("#userFavorites").hide();
	var url = "/hj_flea_market/getUserSale";
	var data ={};
	data.pageSize = 5;
	data.offset = 0;
	$.ajax({
		url: url,
		type: "post",
		data: JSON.stringify(data),
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				var sales = result.goodsList;
				initUserSale(sales);
				$("#userSale .pagination").pagination({
					pageCount:result.totalPage,
		            coping:true,
		            isHide:true,
		            homePage:'首页',
		            endPage:'末页',
		            prevContent:'上页',
		            nextContent:'下页',
		            current:1,
		            callback: function(api){
		            	data.offset=(api.getCurrent() - 1) * data.pageSize;
		            	$.ajax({
		            		url: url,
		            		type: "post",
		            		data: JSON.stringify(data),
		            		dataType: "json",
		            		contentType: "application/json; charset=utf-8",
		            		success: function(result){
		            			if(result.retCode == 0){
		            				initUserSale(result.goodsList);
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

function initUserSale(sales){
	var s = "";
	for(var i = 0; i < sales.length; i++){
		var state = "";
		if(sales[i].gState == 0){
			state = "待审核";
		}else if(sales[i].gState == 1){
			state = "已上架";
		}else if(sales[i].gState == 3){
			state = "已下架";
		}else if(sales[i].gState == 4){
			state = "删除";
		}else if(sales[i].gState == 5){
			state = "驳回";
		}
		s += '<div class="show"><a class="clearfix pull-left" target="_blank" href="/hj_flea_market/goods?gId='+ sales[i].gId +'">'
			+'<img alt="'+sales[i].gName+'" src="'+sales[i].gImage+'" class="showImage"></a>'
			+'<div class="show_info"><h2>标题：'
			+'<a target="_blank" href="/hj_flea_market/goods?gId='+ sales[i].gId +'">'+sales[i].gName+'</a></h2><h5>期望价格：'+sales[i].gPrice+'</h5>'
			+'</div><div class="show_state">'
			+'<span class="onsaling">'+state+'</span>'
			+'<a class="edit" onclick="editSale(this)" data-gId="'+sales[i].gId+'">'
			+'<span class="pull-right btn btn-primary btn-sm">编 辑</span>'
			+'</a></div></div>';
	}
	$("#userSale ul").eq(0).html(s);
}

function showFavorites(){
	$(".item-base li").removeClass("current");
	$("#my_info").hide();
	$("#userSale").hide();
	$("#userFavorites").show();
	$(".item-favor").addClass("current");
	var url = "/hj_flea_market/getUserFavorites";
	var data = {};
	data.pageSize = 5;
	data.offset = 0;
	$.ajax({
		url: url,
		type: "post",
		data: JSON.stringify(data),
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				initFavorites(result.favoritesList);
				$("#userFavorites .pagination").pagination({
					pageCount:result.totalPage,
		            coping:true,
		            isHide:true,
		            homePage:'首页',
		            endPage:'末页',
		            prevContent:'上页',
		            nextContent:'下页',
		            current:1,
		            callback: function(api){
		            	data.offset=(api.getCurrent() - 1) * data.pageSize;
		            	$.ajax({
		            		url: url,
		            		type: "post",
		            		data: JSON.stringify(data),
		            		dataType: "json",
		            		contentType: "application/json; charset=utf-8",
		            		success: function(result){
		            			if(result.retCode == 0){
		            				initFavorites(result.favoritesList);
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

function initFavorites(favorites){
	var s = "";
	for(var i = 0; i < favorites.length; i++){
		var state = "";
		if(favorites[i].gState == 0){
			state = "待审核";
		}else if(favorites[i].gState == 1){
			state = "待上架";
		}else if(favorites[i].gState == 2){
			state = "已上架";
		}else if(favorites[i].gState == 3){
			state = "已下架";
		}else if(favorites[i].gState == 4){
			state = "已删除";
		}else if(favorites[i].gState == 5){
			state = "驳回";
		}
		s += '<div class="show"><a class="clearfix pull-left" target="_blank" href="/hj_flea_market/goods?gId='+ favorites[i].gId +'">'
			+'<img alt="'+favorites[i].gName+'" src="'+favorites[i].gImage+'" class="showImage"></a>'
			+'<div class="show_info"><h2>标题：'
			+'<a target="_blank" href="/hj_flea_market/goods?gId='+ favorites[i].gId +'">'+favorites[i].gName+'</a></h2><h5>价格：'+favorites[i].gPrice+'</h5>'
			+'</div><div class="show_state">'
			+'<span class="onsaling">'+state+'</span>'
			+'<a class="edit" onclick="deleteFavorites(this)" data-fId="'+favorites[i].fId+'">'
			+'<span class="pull-right btn btn-warning btn-sm">删 除</span>'
			+'</a></div></div>';
	}
	$("#userFavorites ul").eq(0).html(s);
}

function deleteFavorites(obj){
	var fId = $(obj).attr("data-fId");
	var data = {};
	data.fId = fId;
	layer.confirm('确定删除收藏？', {
		  btn: ['取消','确定'] //按钮
	}, function(){
	  layer.close(layer.index);
	}, function(){
	  $.ajax({
		  url: "/hj_flea_market/deleteFavorites",
		  type: "post",
		  data: JSON.stringify(data),
		  dataType: "json",
		  contentType: "application/json; charset=utf-8",
		  success: function(result){
			  if(result.retCode == 0){
				  layer.msg("删除成功");
				  showFavorites();
			  }else {
				  layer.msg(result.retMsg);
			  }
		  }
	  });
	});
}

function editSale(obj){
	layer.open({
		title: '二手商品信息修改',
        type: 2,
        skin: 'layui-layer-rim', //加上边框
        area: ['70%', '80%'], //宽高
        content: '/hj_flea_market/editSalePage', //弹出的页面
        shadeClose: false, //点击遮罩关闭
        success: function (layero, index) {
        	var gId = $(obj).attr("data-gId");
        	var data = {};
        	data.gId = gId;
        	$.ajax({
        		url: "/hj_flea_market/getSaleReturn",
        		type: "post",
        		dataType: "json",
        		data: JSON.stringify(data),
        		contentType: "application/json; charset=utf-8",
        		success: function(result){
        			if(result.retCode == 0){
        				var body = layer.getChildFrame('body', index);
        	        	body.find("#title").val(result.goods.gName);
        	        	body.find("#detail").val(result.goods.gDescription);
        	        	body.find("#salePage").attr("src", result.goods.gImage);
        	        	body.find("#salePage").attr("alt", result.goods.gName);
        	        	body.find("#goodsId").val(result.goods.gId);
        	        	body.find("#address").attr("placeholder", result.goods.gAddress);
        	        	body.find("#price").attr("value",result.goods.gPrice);
        	        	var ablum = result.goods.pictures;
        	        	var ss = "";
        	        	for(var i = 0; i < ablum.length; i++){
        	        		ss += '<img src="'+ablum[i].pUrl+'" class="ablumitem">';
        	        	}
        	        	body.find("#album").html(ss);
        	        	
        			}else {
        				layer.msg(result.retMsg);
        			}
        		}
        	});
        }
	});
}

/**
 * 回显
 * @param gid
 */
function getSaleReturn(gid){
	var data = {};
	data.gId = gid;
	$.ajax({
		url: "/hj_flea_market/getSaleReturn",
		type: "post",
		dataType: "json",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				return result.goods;
			}else {
				layer.msg(result.retMsg);
			}
		}
	});
}
