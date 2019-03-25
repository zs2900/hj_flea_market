/*
 * 文 件 名:  UserLoginReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.req;

import com.ecjtu.common.controller.request.IRequest;
import com.ecjtu.common.validator.annotations.Location;
import com.ecjtu.common.validator.annotations.Param;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "")
public class UserLoginReq implements IRequest
{
    private String userEmail;
    
    private String userPWD;
    
    private String userImgCode;
    
    /**
     * @return 返回 userEmail
     */
    @Param(canBlank = false)
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
     * @return 返回 userPWD
     */
    @Param(canBlank = false)
    public String getUserPWD()
    {
        return userPWD;
    }
    
    /**
     * @param 对userPWD进行赋值
     */
    public void setUserPWD(String userPWD)
    {
        this.userPWD = userPWD;
    }
    
    /**
     * @return 返回 userImgCode
     */
    @Param(canBlank = false)
    public String getUserImgCode()
    {
        return userImgCode;
    }
    
    /**
     * @param 对userImgCode进行赋值
     */
    public void setUserImgCode(String userImgCode)
    {
        this.userImgCode = userImgCode;
    }
    
}
