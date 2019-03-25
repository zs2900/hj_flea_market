$(function(){
	var gId = getRequest();
	initPage(gId);
})

function initPage(data){
	$.ajax({
		url: "/hj_flea_market/getGoodsInfo",
		type: "post",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				$("input[name='gId']").attr("value", result.goodsInfo.gId);
				$("input[name='gName']").attr("value", result.goodsInfo.gName);
				$("input[name='gType']").attr("value", result.goodsInfo.gType);
				$("input[name='gPrice']").attr("value", result.goodsInfo.gPrice);
				$("input[name='gAddress']").attr("value", result.goodsInfo.gAddress);
				$("textarea[name='gDescription']").attr("value", result.goodsInfo.gDescription);
				$("#gImage").html('<label for="" class="layui-form-label">商品标题图</label>'
			  		  	+'<img alt=""  src="'+result.imageRoot + result.goodsInfo.gImage+'" height="100px" width="100px">');
				var pictures = result.goodsInfo.pictures;
				var ss ='<label for="" class="layui-form-label">商品展示图</label>';
				for(var i = 0; i < pictures.length; i++){
					ss += '<img alt="" src="'+result.imageRoot+pictures[i].pUrl+'" height="100px" width="100px" id="imagedisplaylist">';
				}
				$("#gDisplayImages").html(ss);
			}else {
				layer.msg(result.retMsg);
			}
		}
	});
}

function SaleGoodsPass(flag){
	var gId = $("input[name='gId']").val();
	var data = {};
	data.gId = gId;
	data.gState = flag;
	$.ajax({
		url: "/hj_flea_market/examineGoods",
		type: "post",
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				layer.msg("操作成功！",{time:300});
				x_admin_close();
				x_admin_father_reload();
			}else {
				layer.msg(result.retMsg);
				x_admin_close();
				x_admin_father_reload();
			}
			
		}
	});
}