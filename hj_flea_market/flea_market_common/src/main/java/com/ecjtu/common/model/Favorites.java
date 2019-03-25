/*
 * 文 件 名:  Favorites.java
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
import java.util.Date;

/**
 * 收藏夹
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Favorites
{
    private Integer fId;
    
    private Integer uId;
    
    private Integer gId;
    
    private Timestamp fCollectionTime;
    
    private Integer fIsDelete;
    
    /**
     * @return 返回 fId
     */
    public Integer getfId()
    {
        return fId;
    }
    
    /**
     * @param 对fId进行赋值
     */
    public void setfId(Integer fId)
    {
        this.fId = fId;
    }
    
    /**
     * @return 返回 uId
     */
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
     * @return 返回 fCollectionTime
     */
    public Date getfCollectionTime()
    {
        return fCollectionTime;
    }
    
    /**
     * @param 对fCollectionTime进行赋值
     */
    public void setfCollectionTime(Timestamp fCollectionTime)
    {
        this.fCollectionTime = fCollectionTime;
    }
    
    /**
     * @return 返回 fIsDelete
     */
    public Integer getfIsDelete()
    {
        return fIsDelete;
    }
    
    /**
     * @param 对fIsDelete进行赋值
     */
    public void setfIsDelete(Integer fIsDelete)
    {
        this.fIsDelete = fIsDelete;
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
        return "Favorites [fId=" + fId + ", uId=" + uId + ", gId=" + gId + ", fCollectionTime=" + fCollectionTime
            + ", fIsDelete=" + fIsDelete + "]";
    }
    
}
