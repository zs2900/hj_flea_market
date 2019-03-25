/*
 * 文 件 名:  UpdateHeadPicReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月18日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.req;

import com.ecjtu.common.controller.request.BaseRequest;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月18日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class UpdateHeadPicReq extends BaseRequest
{
    private String image;
    
    /**
     * @return 返回 image
     */
    public String getImage()
    {
        return image;
    }
    
    /**
     * @param 对image进行赋值
     */
    public void setImage(String image)
    {
        this.image = image;
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
        return "UpdateHeadPicReq [image=" + image + "]";
    }
    
}
