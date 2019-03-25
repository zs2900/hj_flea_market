var $image = $(".cropper-img");

$(function() {
	$image.cropper({
		aspectRatio: 1/1, // 裁剪框的比例，一般设置为方形，即1:1
		viewMode: 1, // 裁剪框不能超出图片，默认：0(允许)
		preview: $(".preview-img").selector, // 预览头像的jq选择器
		dragMode: 'move', // 鼠标移除裁剪框后能直接移动图片
		guides: false, // 是在允许在裁剪框中显示虚线网格，默认：true
		center: false, // 是否显示裁剪框中间的小“+”号，默认：true
		dragCrop: false, // 是否允许通过拖拽创建一个新的裁剪区域，默认：true
		movable: true, // 是否允许移动图片，默认：true
		cropBoxResizable: true, // 是否允许改变裁剪框的大小，默认：true
		toggleDragModeOnDblclick: false, // 是否允许通过在图片双击来重建裁剪框，默认：true
		minCropBoxWidth: 200, //裁剪框的最小宽度，这也是初始化时裁剪框的宽度
		minCropBoxHeight: 200, // 裁剪框的最小高度，这也是初始化时裁剪框的高度
		ready: function() {
			$image.cropper('setCropBoxData', {width:200, height:200})
		}
	})

})

/**
 * 选择更换头像的图片
 */
function choose_img(file) {
	// 如果是谷歌或者火狐
	if(file.files && file.files[0]) {
		var url = '';
		var reader = new FileReader();
        reader.onload = function (evt) {
            url = evt.target.result;
            // 更换画布中的图片
            $image.cropper('replace', url);
        }
        reader.readAsDataURL(file.files[0]);
	}
	else {
		// 否则是IE
		file.select();
        var src = document.selection.createRange().text;
        var img = document.getElementById('cropper-img');
        img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
	}

}

/**
 * 判断是否图片
 * @param object file
 */
function is_image(file) {
	if (file.type) {
	  return /^image\/\w+$/.test(file.type);
	} else {
	  return /\.(jpg|jpeg|png|gif)$/.test(file);
	}
}

/**
 * 旋转图片，每次顺时针旋转45度
 */
function rotate_avator() {
	var degree = 45;
	$image.cropper('rotate', degree);
}

/**
 * 放大头像
 */
function zoom_out() {
	$image.cropper('zoom', 0.1);
}

/**
 * 缩小头像
 */
function zoom_in() {
	$image.cropper('zoom', -0.1);
}

/**
 * 上传图片
 */
function upload_avator() {
	var data = $image.cropper('getCroppedCanvas',{"width":200, "height":200}).toDataURL();
	var url = '/hj_flea_market/updateHeadPic';
	$.ajax({
		url: url,
		type: "post",
		data: JSON.stringify({'image': data}),
		contentType: "application/json; charset=utf-8",
		success: function(result){
			if(result.retCode == 0) {
				layer.msg('头像上传成功');
				location.reload();
			} else {
				layer.alert('头像上传失败');
			}
		}
	});
	
}
