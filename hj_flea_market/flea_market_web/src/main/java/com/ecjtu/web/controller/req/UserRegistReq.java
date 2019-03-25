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
    
    String userEmailCode;
    
    /**
     * @return 返回 userName
     */
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
