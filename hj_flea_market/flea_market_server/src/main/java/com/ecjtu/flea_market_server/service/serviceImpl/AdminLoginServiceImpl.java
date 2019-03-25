/*
 * 文 件 名:  AdminLoginServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.service.serviceImpl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.flea_market_server.controller.req.AdminLoginReq;
import com.ecjtu.flea_market_server.controller.resp.AdminLoginResp;
import com.ecjtu.flea_market_server.service.AdminLoginService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService
{
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public AdminLoginResp adminLogin(AdminLoginReq req)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(AdminLoginReq.class, req);
        
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(req.getUserName(), req.getPassword());
        try
        {
            subject.login(token); //完成登录
            return new AdminLoginResp("/hj_flea_market/adminPage", req.getUserName());
        }
        catch (Exception e)
        {
            AdminLoginResp resp = new AdminLoginResp();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return resp;
        }
    }
    
}
