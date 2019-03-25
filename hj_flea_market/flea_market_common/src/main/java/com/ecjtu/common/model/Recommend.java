/*
 * 文 件 名:  Recommend.java
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

/**
 * 商品推荐
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Recommend
{
    private Integer rId;
    
    private Integer gId;
    
    private Timestamp rAddTime;
    
    /**
     * @return 返回 rId
     */
    public Integer getrId()
    {
        return rId;
    }
    
    /**
     * @param 对rId进行赋值
     */
    public void setrId(Integer rId)
    {
        this.rId = rId;
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
     * @return 返回 rAddTime
     */
    public Timestamp getrAddTime()
    {
        return rAddTime;
    }
    
    /**
     * @param 对rAddTime进行赋值
     */
    public void setrAddTime(Timestamp rAddTime)
    {
        this.rAddTime = rAddTime;
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
        return "Recommend [rId=" + rId + ", gId=" + gId + ", rAddTime=" + rAddTime + "]";
    }
    
}
