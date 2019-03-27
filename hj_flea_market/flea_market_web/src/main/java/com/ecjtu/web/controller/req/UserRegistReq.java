/*
 * 文 件 名:  UserRegistReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.req;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.BaseRequest;
import com.ecjtu.common.validator.annotations.Location;
import com.ecjtu.common.validator.annotations.Param;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "")
public class UserRegistReq extends BaseRequest
{
    String userName;
    
    String userEmail;
    
    String userPassword;
    
    String surePassword;
    
    String userEmailCode;
    
    /**
     * @return 返回 userName
     */
    @Param(canBlank = false, regex = "^[\\w]{4,10}$")
    public String getUserName()
    {
        return userName;
    }
    
    /**
     * @param 对userName进行赋值
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    /**
     * @return 返回 userEmail 
     */
    @Param(canBlank = false, regex = "^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$")
    
    public String getUserEmail()
    {
        return userEmail;
    }
    
    /**
     * @param 对userEmail进行赋值
     */
    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }
    
    /**
     * @return 返回 userPassword
     */
    @Param(canBlank = false, regex = "^[a-z0-9_A-Z]{6,12}$")
    public String getUserPassword()
    {
        return userPassword;
    }
    
    /**
     * @param 对userPassword进行赋值
     */
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
    
    /**
     * @return 返回 userEmailCode
     */
    @Param(canBlank = false, regex = "^[0-9a-zA-Z]{6}$")
    public String getUserEmailCode()
    {
        return userEmailCode;
    }
    
    /**
     * @param 对userEmailCode进行赋值
     */
    public void setUserEmailCode(String userEmailCode)
    {
        this.userEmailCode = userEmailCode;
    }
    
    /**
     * @return 返回 surePassword
     */
    @Param(canBlank = false, regex = "^[a-z0-9_A-Z]{6,12}$")
    public String getSurePassword()
    {
        return surePassword;
    }
    
    /**
     * @param 对surePassword进行赋值
     */
    public void setSurePassword(String surePassword)
    {
        this.surePassword = surePassword;
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
