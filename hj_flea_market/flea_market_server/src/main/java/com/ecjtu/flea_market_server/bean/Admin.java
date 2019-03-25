/*
 * 文 件 名:  Admin.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Admin
{
    private Integer aId;
    
    private String aName;
    
    private String aPassword;
    
    /**
     * @return 返回 aId
     */
    public Integer getaId()
    {
        return aId;
    }
    
    /**
     * @param 对aId进行赋值
     */
    public void setaId(Integer aId)
    {
        this.aId = aId;
    }
    
    /**
     * @return 返回 aName
     */
    public String getaName()
    {
        return aName;
    }
    
    /**
     * @param 对aName进行赋值
     */
    public void setaName(String aName)
    {
        this.aName = aName;
    }
    
    /**
     * @return 返回 aPassword
     */
    public String getaPassword()
    {
        return aPassword;
    }
    
    /**
     * @param 对aPassword进行赋值
     */
    public void setaPassword(String aPassword)
    {
        this.aPassword = aPassword;
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
