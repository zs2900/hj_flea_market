/*
 * 文 件 名:  DisplayManagerReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller.req;

import java.sql.Timestamp;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.BaseRequest;
import com.ecjtu.common.validator.annotations.Location;
import com.ecjtu.common.validator.annotations.Param;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "")
public class DisplayManagerReq extends BaseRequest
{
    private Integer dId;
    
    private Integer gId;
    
    private String dImg;
    
    private Timestamp dAddTime;
    
    /**
     * @return 返回 dId
     */
    @Param(canBlank = true, regex = "^[\\d]+$")
    public Integer getdId()
    {
        return dId;
    }
    
    /**
     * @param 对dId进行赋值
     */
    public void setdId(Integer dId)
    {
        this.dId = dId;
    }
    
    /**
     * @return 返回 gId
     */
    @Param(canBlank = false, regex = "^[\\d]+$")
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
     * @return 返回 dImg
     */
    @Param(canBlank = false, regex = "^[\\w,/,.]+$")
    public String getdImg()
    {
        return dImg;
    }
    
    /**
     * @param 对dImg进行赋值
     */
    public void setdImg(String dImg)
    {
        this.dImg = dImg;
    }
    
    /**
     * @return 返回 dAddTime
     */
    @Param(canBlank = true)
    public Timestamp getdAddTime()
    {
        return dAddTime;
    }
    
    /**
     * @param 对dAddTime进行赋值
     */
    public void setdAddTime(Timestamp dAddTime)
    {
        this.dAddTime = dAddTime;
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
