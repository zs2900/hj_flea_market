/*
 * 文 件 名:  SelectGoodsDetailResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月14日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.resp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.response.LoginStateBaseResponse;
import com.ecjtu.common.model.Picture;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月14日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SelectGoodsDetailResp extends LoginStateBaseResponse
{
    private Integer gId;
    
    private String gName;
    
    private Integer gType;
    
    private Double gPrice;
    
    private Timestamp gUpdateTime;
    
    private String gDescription;
    
    private Integer gNumber;
    
    private String gImage;
    
    private Integer uId;
    
    private String uName;
    
    private String uAddress;
    
    private String uPhoneNumber;
    
    private String uHeadPic;
    
    private String uQQNumber;
    
    private String uSchool;
    
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
     * @return 返回 gType
     */
    public Integer getgType()
    {
        return gType;
    }
    
    /**
     * @param 对gType进行赋值
     */
    public void setgType(Integer gType)
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
    public Date getgUpdateTime()
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
     * @return 返回 uName
     */
    public String getuName()
    {
        return uName;
    }
    
    /**
     * @param 对uName进行赋值
     */
    public void setuName(String uName)
    {
        this.uName = uName;
    }
    
    /**
     * @return 返回 uAddress
     */
    public String getuAddress()
    {
        return uAddress;
    }
    
    /**
     * @param 对uAddress进行赋值
     */
    public void setuAddress(String uAddress)
    {
        this.uAddress = uAddress;
    }
    
    /**
     * @return 返回 uPhoneNumber
     */
    public String getuPhoneNumber()
    {
        return uPhoneNumber;
    }
    
    /**
     * @param 对uPhoneNumber进行赋值
     */
    public void setuPhoneNumber(String uPhoneNumber)
    {
        this.uPhoneNumber = uPhoneNumber;
    }
    
    /**
     * @return 返回 uQQNumber
     */
    public String getuQQNumber()
    {
        return uQQNumber;
    }
    
    /**
     * @param 对uQQNumber进行赋值
     */
    public void setuQQNumber(String uQQNumber)
    {
        this.uQQNumber = uQQNumber;
    }
    
    /**
     * @return 返回 uSchool
     */
    public String getuSchool()
    {
        return uSchool;
    }
    
    /**
     * @param 对uSchool进行赋值
     */
    public void setuSchool(String uSchool)
    {
        this.uSchool = uSchool;
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
     * @return 返回 uHeadPic
     */
    public String getuHeadPic()
    {
        return uHeadPic;
    }
    
    /**
     * @param 对uHeadPic进行赋值
     */
    public void setuHeadPic(String uHeadPic)
    {
        this.uHeadPic = uHeadPic;
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
