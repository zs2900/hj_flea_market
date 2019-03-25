/*
 * 文 件 名:  Picture.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月7日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.bean;

import java.sql.Timestamp;

/**
 * 图片
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Picture
{
    private Integer pId;
    
    private String pCode;
    
    private String pUrl;
    
    private Integer gId;
    
    private Timestamp pUpdateTime;
    
    /**
     * @return 返回 pId
     */
    public Integer getpId()
    {
        return pId;
    }
    
    /**
     * @param 对pId进行赋值
     */
    public void setpId(Integer pId)
    {
        this.pId = pId;
    }
    
    /**
     * @return 返回 pCode
     */
    public String getpCode()
    {
        return pCode;
    }
    
    /**
     * @param 对pCode进行赋值
     */
    public void setpCode(String pCode)
    {
        this.pCode = pCode;
    }
    
    /**
     * @return 返回 pUrl
     */
    public String getpUrl()
    {
        return pUrl;
    }
    
    /**
     * @param 对pUrl进行赋值
     */
    public void setpUrl(String pUrl)
    {
        this.pUrl = pUrl;
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
     * @return 返回 pUpdateTime
     */
    public Timestamp getpUpdateTime()
    {
        return pUpdateTime;
    }
    
    /**
     * @param 对pUpdateTime进行赋值
     */
    public void setpUpdateTime(Timestamp pUpdateTime)
    {
        this.pUpdateTime = pUpdateTime;
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
        return "Picture [pId=" + pId + ", pCode=" + pCode + ", pUrl=" + pUrl + ", gId=" + gId + ", pUpdateTime="
            + pUpdateTime + "]";
    }
    
}
