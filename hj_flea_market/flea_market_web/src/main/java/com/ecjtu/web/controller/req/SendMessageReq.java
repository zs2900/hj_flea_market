/*
 * 文 件 名:  SendMessageReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月15日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.req;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.BaseRequest;
import com.ecjtu.common.validator.annotations.Location;
import com.ecjtu.common.validator.annotations.Param;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月15日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "")
public class SendMessageReq extends BaseRequest
{
    private Integer gId;
    
    private Integer uId;
    
    private String mContent;
    
    /**
     * @return 返回 gId
     */
    @Param(canBlank = false)
    public Integer getgId()
    {
        return gId;
    }
    
    /**
     * @param 对gId进行赋值
     */
    public void setgId(Integer gId)
    {
        this.gId = gId;
    }
    
    /**
     * @return 返回 uId
     */
    @Param(canBlank = false)
    public Integer getuId()
    {
        return uId;
    }
    
    /**
     * @param 对uId进行赋值
     */
    public void setuId(Integer uId)
    {
        this.uId = uId;
    }
    
    /**
     * @return 返回 mContent
     */
    @Param(canBlank = false)
    public String getmContent()
    {
        return mContent;
    }
    
    /**
     * @param 对mContent进行赋值
     */
    public void setmContent(String mContent)
    {
        this.mContent = mContent;
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
