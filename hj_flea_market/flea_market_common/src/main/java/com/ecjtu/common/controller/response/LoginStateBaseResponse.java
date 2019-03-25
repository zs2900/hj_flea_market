/*
 * 文 件 名:  LoginStateBaseResponse.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月14日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.controller.response;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月14日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class LoginStateBaseResponse extends BaseResponse
{
    private int isLogin;
    
    /**
     * @return 返回 isLogin
     */
    public int getIsLogin()
    {
        return isLogin;
    }
    
    /**
     * @param 对isLogin进行赋值
     */
    public void setIsLogin(int isLogin)
    {
        this.isLogin = isLogin;
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
        return "LoginStateBaseResponse [isLogin=" + isLogin + "]";
    }
    
}
