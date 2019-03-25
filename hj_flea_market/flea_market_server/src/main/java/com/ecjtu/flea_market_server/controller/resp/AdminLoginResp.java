/*
 * 文 件 名:  AdminLoginResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller.resp;

import com.ecjtu.common.controller.response.BaseResponse;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class AdminLoginResp extends BaseResponse
{
    private String redirectUrl;
    
    /** 
     * <默认构造函数>
     */
    public AdminLoginResp()
    {
    }
    
    /** 
     * <默认构造函数>
     */
    public AdminLoginResp(String redirectUrl)
    {
        this.redirectUrl = redirectUrl;
    }
    
    /**
     * @return 返回 redirectUrl
     */
    public String getRedirectUrl()
    {
        return redirectUrl;
    }
    
    /**
     * @param 对redirectUrl进行赋值
     */
    public void setRedirectUrl(String redirectUrl)
    {
        this.redirectUrl = redirectUrl;
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
        return "AdminLoginResp [redirectUrl=" + redirectUrl + "]";
    }
    
}
