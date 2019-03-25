/*
 * 文 件 名:  UploadImageServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.service.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.util.CheckFileUtil;
import com.ecjtu.common.util.FileUtil;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.flea_market_server.controller.req.FileUploadReq;
import com.ecjtu.flea_market_server.controller.resp.FileUploadResp;
import com.ecjtu.flea_market_server.service.UploadImageService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class UploadImageServiceImpl implements UploadImageService
{
    @Value("${file.save.path}")
    private String imageSavePath;
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    @Override
    public FileUploadResp fileUpload(FileUploadReq req)
        throws Exception
    {
        //参数校验
        Validator.getInstance().validate(FileUploadReq.class, req);
        
        //文件类型判断
        if (!CheckFileUtil.isPictureM(req.getFile()))
        {
            FileUploadResp resp = new FileUploadResp();
            resp.setRetCode(ResultCode.FILE_TYPE_NOT_SUPPORT.getResultCode());
            resp.setRetMsg(ResultCode.FILE_TYPE_NOT_SUPPORT.getResultMsg());
            return resp;
        }
        
        String fileName = req.getFile().getOriginalFilename();
        
        Integer index = fileName.lastIndexOf(".");
        String ext = fileName.substring(index);
        
        String url = "uploads/server";
        
        Long date = System.currentTimeMillis();
        String imgName = date.toString() + ext;
        Map<String, Object> map = FileUtil.saveImg(req.getFile().getInputStream(), imageSavePath, imgName, url);
        
        FileUploadResp resp = new FileUploadResp();
        resp.setImagePath(map.get("url").toString());
        return resp;
    }
    
}
