/*
 * 文 件 名:  User.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年2月20日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.bean;

import java.sql.Timestamp;

import com.alibaba.fastjson.JSONObject;

/**
 * user bean
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年2月20日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class User
{
    private Integer uId;
    
    private String uName;
    
    private String uEmail;
    
    private String uPassword;
    
    private Integer uAge;
    
    private Integer uSex;
    
    private String uAddress;
    
    private Timestamp uRegistrationTime;
    
    private String uQQNumber;
    
    private String uPhoneNum;
    
    private String uSchool;
    
    private String uHeadPic;
    
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
     * @return 返回 uSex
     */
    public Integer getuSex()
    {
        return uSex;
    }
    
    /**
     * @param 对uSex进行赋值
     */
    public void setuSex(Integer uSex)
    {
        this.uSex = uSex;
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
     * @return 返回 uEmail
     */
    public String getuEmail()
    {
        return uEmail;
    }
    
    /**
     * @param 对uEmail进行赋值
     */
    public void setuEmail(String uEmail)
    {
        this.uEmail = uEmail;
    }
    
    /**
     * @return 返回 uPassword
     */
    public String getuPassword()
    {
        return uPassword;
    }
    
    /**
     * @param 对uPassword进行赋值
     */
    public void setuPassword(String uPassword)
    {
        this.uPassword = uPassword;
    }
    
    /**
     * @return 返回 uAge
     */
    public Integer getuAge()
    {
        return uAge;
    }
    
    /**
     * @param 对uAge进行赋值
     */
    public void setuAge(Integer uAge)
    {
        this.uAge = uAge;
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
     * @return 返回 uRegistrationTime
     */
    public Timestamp getuRegistrationTime()
    {
        return uRegistrationTime;
    }
    
    /**
     * @param 对uRegistrationTime进行赋值
     */
    public void setuRegistrationTime(Timestamp uRegistrationTime)
    {
        this.uRegistrationTime = uRegistrationTime;
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
     * @return 返回 uPhoneNum
     */
    public String getuPhoneNum()
    {
        return uPhoneNum;
    }
    
    /**
     * @param 对uPhoneNum进行赋值
     */
    public void setuPhoneNum(String uPhoneNum)
    {
        this.uPhoneNum = uPhoneNum;
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
     * 打印实体
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
