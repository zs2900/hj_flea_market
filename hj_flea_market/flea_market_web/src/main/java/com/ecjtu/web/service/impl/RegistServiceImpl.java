/*
 * 文 件 名:  RegistServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service.impl;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.web.controller.req.EmailCodeReq;
import com.ecjtu.web.controller.req.UserRegistReq;
import com.ecjtu.web.controller.resp.EmailCodeResp;
import com.ecjtu.web.controller.resp.UserRegistResp;
import com.ecjtu.web.service.RegistService;
import com.ecjtu.web.util.MailUtil;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class RegistServiceImpl implements RegistService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistServiceImpl.class);
    
    @Override
    public EmailCodeResp getEmailCode(EmailCodeReq emailCodeReq, HttpSession session)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(EmailCodeReq.class, emailCodeReq);
        String emailCode = MailUtil.getRadomNum();
        EmailCodeResp emailCodeResp = null;
        try
        {
            MailUtil.send_mail(emailCodeReq.getUserEmail(), emailCode);
            session.setAttribute("emailCode", emailCode);
            emailCodeResp = new EmailCodeResp();
            emailCodeResp.setRetCode(ResultCode.SUCCESS.getResultCode());
            emailCodeResp.setRetMsg(ResultCode.SUCCESS.getResultMsg());
            LOGGER.info("emailCode : {} , userRegistResp : {}", emailCode, emailCodeResp.toString());
            return emailCodeResp;
        }
        catch (MessagingException e)
        {
            emailCodeResp = new EmailCodeResp();
            emailCodeResp.setRetCode(ResultCode.SERVICE_ERROR.getResultCode());
            emailCodeResp.setRetMsg(e.getMessage());
            LOGGER.info("emailCode : {} , userRegistResp : {}", emailCode, emailCodeResp.toString());
            return emailCodeResp;
        }
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param registReq
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Override
    public UserRegistResp registAcount(UserRegistReq registReq)
        throws InnerException
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}
