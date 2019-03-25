/*
 * 文 件 名:  SelectGoodsAdmin.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月22日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.bean.resp;

import java.sql.Timestamp;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.model.Picture;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SelectGoodsAdmin
{
    private Integer gId;
    
    private String gName;
    
    private String gType;
    
    private Double gPrice;
    
    private Timestamp gUpdateTime;
    
    private String gDescription;
    
    private String gAddress;
    
    private Integer gNumber;
    
    private Integer gState;
    
    private String gImage;
    
    private Integer uId;
    
    private List<Picture> pictures;
    
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
     * @return 返回 gName
     */
    public String getgName()
    {
        return gName;
    }
    
    /**
     * @param 对gName进行赋值
     */
    public void setgName(String gName)
    {
        this.gName = gName;
    }
    
    /**
     * @return 返回 gType
     */
    public String getgType()
    {
        return gType;
    }
    
    /**
     * @param 对gType进行赋值
     */
    public void setgType(String gType)
    {
        this.gType = gType;
    }
    
    /**
     * @return 返回 gPrice
     */
    public Double getgPrice()
    {
        return gPrice;
    }
    
    /**
     * @param 对gPrice进行赋值
     */
    public void setgPrice(Double gPrice)
    {
        this.gPrice = gPrice;
    }
    
    /**
     * @return 返回 gUpdateTime
     */
    public Timestamp getgUpdateTime()
    {
        return gUpdateTime;
    }
    
    /**
     * @param 对gUpdateTime进行赋值
     */
    public void setgUpdateTime(Timestamp gUpdateTime)
    {
        this.gUpdateTime = gUpdateTime;
    }
    
    /**
     * @return 返回 gDescription
     */
    public String getgDescription()
    {
        return gDescription;
    }
    
    /**
     * @param 对gDescription进行赋值
     */
    public void setgDescription(String gDescription)
    {
        this.gDescription = gDescription;
    }
    
    /**
     * @return 返回 gAddress
     */
    public String getgAddress()
    {
        return gAddress;
    }
    
    /**
     * @param 对gAddress进行赋值
     */
    public void setgAddress(String gAddress)
    {
        this.gAddress = gAddress;
    }
    
    /**
     * @return 返回 gNumber
     */
    public Integer getgNumber()
    {
        return gNumber;
    }
    
    /**
     * @param 对gNumber进行赋值
     */
    public void setgNumber(Integer gNumber)
    {
        this.gNumber = gNumber;
    }
    
    /**
     * @return 返回 gState
     */
    public Integer getgState()
    {
        return gState;
    }
    
    /**
     * @param 对gState进行赋值
     */
    public void setgState(Integer gState)
    {
        this.gState = gState;
    }
    
    /**
     * @return 返回 gImage
     */
    public String getgImage()
    {
        return gImage;
    }
    
    /**
     * @param 对gImage进行赋值
     */
    public void setgImage(String gImage)
    {
        this.gImage = gImage;
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
     * @return 返回 pictures
     */
    public List<Picture> getPictures()
    {
        return pictures;
    }
    
    /**
     * @param 对pictures进行赋值
     */
    public void setPictures(List<Picture> pictures)
    {
        this.pictures = pictures;
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
