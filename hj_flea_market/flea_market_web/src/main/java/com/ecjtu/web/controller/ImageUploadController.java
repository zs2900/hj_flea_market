/*
 * 文 件 名:  ImageUploadController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月17日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.util.MD5Util;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
import com.ecjtu.web.controller.resp.ImageUploadResp;
import com.ecjtu.web.util.TimeUtil;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@AOPLogAnnotation
@RestController
public class ImageUploadController
{
    
    @RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
    @ResponseBody
    public ImageUploadResp imageUpload(@RequestParam("file") MultipartFile file, HttpSession session)
        throws Exception
    {
        // 判断文件是否为空  
        if (!file.isEmpty())
        {
            // 文件保存路径  
            String filePath = session.getServletContext().getRealPath("/") + "uploads/salebuy/"
                + TimeUtil.getCurrentDate() + File.separator;
            String fileName = MD5Util.md5Hex(file.getOriginalFilename()) + ".jpg";
            // 转存文件  
            File file2 = new File(filePath);
            if (!file2.exists())
            {
                file2.mkdirs();
            }
            file.transferTo(new File(filePath + fileName));
            ImageUploadResp resp = new ImageUploadResp();
            resp.setSavepath(filePath.substring(filePath.lastIndexOf("uploads")));
            resp.setSavename(fileName);
            resp.setRetCode(ResultCode.SUCCESS.getResultCode());
            resp.setRetMsg(ResultCode.SUCCESS.getResultMsg());
            return resp;
        }
        else
        {
            ImageUploadResp resp = new ImageUploadResp();
            resp.setRetCode(ResultCode.FILE_IS_EMPTY.getResultCode());
            resp.setRetMsg(ResultCode.FILE_IS_EMPTY.getResultMsg());
            return resp;
        }
    }
}
