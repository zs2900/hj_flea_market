/*
 * 文 件 名:  ImageUploadResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月17日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.resp;

import com.ecjtu.common.controller.response.BaseResponse;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ImageUploadResp extends BaseResponse
{
    private String savepath;
    
    private String savename;
    
    /**
     * @return 返回 savepath
     */
    public String getSavepath()
    {
        return savepath;
    }
    
    /**
     * @param 对savepath进行赋值
     */
    public void setSavepath(String savepath)
    {
        this.savepath = savepath;
    }
    
    /**
     * @return 返回 savename
     */
    public String getSavename()
    {
        return savename;
    }
    
    /**
     * @param 对savename进行赋值
     */
    public void setSavename(String savename)
    {
        this.savename = savename;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Override
    public String toString()
    {
        return "ImageUploadResp [savepath=" + savepath + ", savename=" + savename + "]";
    }
    
}
