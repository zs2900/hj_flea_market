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

var param = {
	pageSize : dataObj.limit_enterprise,
	offset : 0
}

$(function(){
	initDisplay(param);
})

function initDisplay(param){
	$.ajax({
		url: "/hj_flea_market/displayList",
		type: "post",
		dataType: "json",
		data: JSON.stringify(param),
		contentType: "application/json;charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				$("#displayTotal").html("共有数据："+result.totalItem+"条");
				var $_displayList = $("#displayList tbody");
				var ss = "";
				$.each(result.displays,function(i, obj){
					ss += '<tr><td><img src="'+result.imageRoot + obj.dImg+'" height="100px" width="100px"></td><td>'+obj.dId+'</td><td>'+obj.gId+'</td>'
						+ '<td>'+(obj.dState == 0 ? "启用" : "停用")+'</td><td>'+getMyDate(obj.dAddTime)+'</td><td class="td-manage">'
			           	+ '<a onclick="member_stop(this,'+obj.dId+')" href="javascript:;"  title="'+(obj.dState == 0 ? "停用" : "启用")+'">'
			           	+ '<i class="layui-icon">'+(obj.dState == 0 ? "&#xe601;" : "&#xe62f;")+'</i></a>'
						+ '<a title="编辑"  onclick="x_admin_show(\'编辑\',\'/hj_flea_market/displayEdit?dId='+obj.dId+'\',600,400)" href="javascript:;">'
			            + '<i class="layui-icon">&#xe642;</i></a>'
			            + '<a title="删除" onclick="member_del(this,'+obj.dId+')" href="javascript:;">' 
			            + '<i class="layui-icon">&#xe640;</i></a></td></tr>'; 
				});
				$_displayList.html(ss);
				
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage;
					laypage.render({
						elem: 'Pagination',			//注意，这里的 yscxPage 是 ID，不用加 # 号
						count: result.totalItem,    //数据总数，从服务端得到
						limit: dataObj.limit_enterprise,
		                layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
		                curr: dataObj.page_enterprise,
		                theme: '#1E9FFF',
						jump: function(obj, first){
						    //首次不执行
						    if(!first){
						    	dataObj.page_enterprise = obj.curr; 
		                        dataObj.limit_enterprise = obj.limit;
		                        param.offset = (obj.curr - 1) * dataObj.limit_enterprise;
		                        param.pageSize = dataObj.limit_enterprise;
		                        initDisplay(param);
						    }
				        }
				    });
				});
			}else {
				layer.msg(result.retMsg);
			}
		}
	});
}

function startDisplay(state, id , startResult){
	var data = {};
	data.dState = state;
	data.dId = id;
	$.ajax({
		url: "/hj_flea_market/startDisplay",
		type: "post",
		dataType: "json",
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function(result){
			if(result.retCode == 0){
				startResult = true;
			}else {
				startResult = false;
			}
		}
	});
}

function seachDisplay(){
	var state = $("#seachByState").val();
	if(state >= 0){
		param.dState = state;
	}
	initDisplay(param); 
}
