/*
 * 文 件 名:  DisplayEditReturnResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月26日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller.resp;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.model.Display;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月26日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DisplayEditReturnResp extends BaseResponse
{
    private Display display;
    
    private String imageRoot;
    
    /**
     * @return 返回 display
     */
    public Display getDisplay()
    {
        return display;
    }
    
    /**
     * @param 对display进行赋值
     */
    public void setDisplay(Display display)
    {
        this.display = display;
    }
    
    /**
     * @return 返回 imageRoot
     */
    public String getImageRoot()
    {
        return imageRoot;
    }
    
    /**
     * @param 对imageRoot进行赋值
     */
    public void setImageRoot(String imageRoot)
    {
        this.imageRoot = imageRoot;
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
        return JSONObject.toJSONString(this);
    }
    
}
