$(function(){
	var param = {};
	param.pageSize = dataObj.limit_enterprise;
	param.offset = 0;
	param.gState = 0;
	getSaleGoods(param);
})

var dataObj = {
    page_enterprise : 1,
    page_order : 1,
    page_log: 1,
    page_log_info: 1,
    limit_enterprise: 10,
    limit_order: 10,
    limit_log:   10,
    limit_log_info: 10
}

function getSaleGoods(param){
	$.ajax({
		url: "/hj_flea_market/manageSale",
		type: "post",
		data: JSON.stringify(param),
		contentType: "application/json;charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				$("#totalDataNum").html('共有数据：'+result.total+' 条');
				$("#salegoodsList tbody").html("")
				var ss = "";
				$.each(result.goods,function(i,obj){
					var url = "/hj_flea_market/examinegoods?gId=" + obj.gId;
					ss += '<tr><td><div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id="2">'
				       + '<i class="layui-icon">&#xe605;</i></div></td>'
					   + '<td>'+obj.gId+'</td><td>'+obj.uId+'</td>'	
					   + '<td>'+obj.gName+'</td><td>'+obj.gType+'</td>'
					   + '<td>'+obj.gPrice+'</td><td>'+obj.gAddress+'</td><td>'+obj.gDescription+'</td>'
					   + '<td>'+getMyDate(obj.gUpdateTime)+'</td><td>'+getState(obj.gState)+'</td><td class="td-manage">'
		               + '<a title="查看" onclick="x_admin_show(\'编辑\',\''+url+'\')" href="javascript:;" data='+JSON.stringify(obj)+'>'
		               + '<i class="layui-icon">&#xe63c;</i>'
		               + '</a></td></tr>';
					
				});
				$("#salegoodsList tbody").html(ss);
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage;
					laypage.render({
						elem: 'pageIndex',			//注意，这里的 yscxPage 是 ID，不用加 # 号
						count: result.total,    //数据总数，从服务端得到
						limit: dataObj.limit_enterprise,
						first: '首页',
		                last: '尾页',
		                layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
		                curr: dataObj.page_enterprise,
		                theme: '#00A0E9',
						jump: function(obj, first){
						    //首次不执行
						    if(!first){
						    	dataObj.page_enterprise = obj.curr; 
		                        dataObj.limit_enterprise = obj.limit;
		                        param.offset = (obj.curr - 1) * dataObj.limit_enterprise;
		                        param.pageSize = dataObj.limit_enterprise;
						    	getSaleGoods(param);
						    }
				        }
				    });
				});
				
			}
		}
	});
}

function getMyDate(str){  
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
    return oTime;  
};  
//补0操作  
function getzf(num){  
    if(parseInt(num) < 10){  
        num = '0'+num;  
    }  
    return num;  
}

function getState(state){
	if(state == 0){
		return "待审核";
	}else if(state == 1){
		return "待上架";
	}else if(state == 2){
		return "已上架";
	}else if(state == 3){
		return "已下架";
	}else if(state == 4){
		return "已删除";
	}else if(state == 5){
		return "驳回";
	}
}