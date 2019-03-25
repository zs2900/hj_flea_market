/*
 * 文 件 名:  FileUploadReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller.req;

import org.springframework.web.multipart.MultipartFile;

import com.ecjtu.common.controller.request.BaseRequest;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class FileUploadReq extends BaseRequest
{
    private MultipartFile file;
    
    /**
     * @return 返回 file
     */
    public MultipartFile getFile()
    {
        return file;
    }
    
    /**
     * @param 对file进行赋值
     */
    public void setFile(MultipartFile file)
    {
        this.file = file;
    }
    
}
