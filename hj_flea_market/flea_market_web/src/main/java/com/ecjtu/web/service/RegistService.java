/*
 * 文 件 名:  RegistService.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service;

import javax.servlet.http.HttpSession;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.web.controller.req.EmailCodeReq;
import com.ecjtu.web.controller.req.UserRegistReq;
import com.ecjtu.web.controller.resp.EmailCodeResp;
import com.ecjtu.web.controller.resp.UserRegistResp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface RegistService
{
    /**
     * 发送邮箱验证码
     * <一句话功能简述>
     * <功能详细描述>
     * @param email 发送邮箱请求体
     * @return 发送邮箱响应实体
     * @see [类、类#方法、类#成员]
     */
    EmailCodeResp getEmailCode(EmailCodeReq emailCodeReq, HttpSession session)
        throws InnerException;
    
    /**
     * 注册账号
     * <一句话功能简述>
     * <功能详细描述>
     * @param registReq 注册账号请求体
     * @return 注册账号响应实体
     * @see [类、类#方法、类#成员]
     */
    UserRegistResp registAcount(UserRegistReq registReq, HttpSession session)
        throws InnerException;
}
