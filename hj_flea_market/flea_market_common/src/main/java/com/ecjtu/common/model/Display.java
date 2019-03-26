/*
 * 文 件 名:  Display.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月7日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.model;

import java.sql.Timestamp;

import com.alibaba.fastjson.JSONObject;

/**
 * 展示栏
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Display
{
    private Integer dId;
    
    private Timestamp dAddTime;
    
    private Integer gId;
    
    private String dImg;
    
    private Integer dState;
    
    /**
     * @return 返回 dId
     */
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
     * @return 返回 dAddTime
     */
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
     * @return 返回 gId
     */
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
     * @return 返回 dState
     */
    public Integer getdState()
    {
        return dState;
    }
    
    /**
     * @param 对dState进行赋值
     */
    public void setdState(Integer dState)
    {
        this.dState = dState;
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
