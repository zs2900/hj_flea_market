/*
 * 文 件 名:  Message.java
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
 * 留言
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Message
{
    private Integer mId;
    
    private Integer uId;
    
    private Integer gId;
    
    private String mContent;
    
    private Timestamp mSendTime;
    
    /**
     * @return 返回 mId
     */
    public Integer getmId()
    {
        return mId;
    }
    
    /**
     * @param 对mId进行赋值
     */
    public void setmId(Integer mId)
    {
        this.mId = mId;
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
     * @return 返回 mContent
     */
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
     * @return 返回 mSendTime
     */
    public Timestamp getmSendTime()
    {
        return mSendTime;
    }
    
    /**
     * @param 对mSendTime进行赋值
     */
    public void setmSendTime(Timestamp mSendTime)
    {
        this.mSendTime = mSendTime;
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
        return "Message [mId=" + mId + ", uId=" + uId + ", gId=" + gId + ", mContent=" + mContent + ", mSendTime="
            + mSendTime + "]";
    }
    
}
