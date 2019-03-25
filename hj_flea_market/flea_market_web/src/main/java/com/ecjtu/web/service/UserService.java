/*
 * 文 件 名:  UserService.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service;

import javax.servlet.http.HttpSession;

import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.web.controller.req.GetUserInfoReq;
import com.ecjtu.web.controller.req.UpdateHeadPicReq;
import com.ecjtu.web.controller.req.UpdateUserInfoReq;
import com.ecjtu.web.controller.req.UserLoginReq;
import com.ecjtu.web.controller.req.UserLoginStateReq;
import com.ecjtu.web.controller.resp.GetuserInfoResp;
import com.ecjtu.web.controller.resp.UpdateuserInfoResp;
import com.ecjtu.web.controller.resp.UserLoginResp;
import com.ecjtu.web.controller.resp.UserLoginStateResp;

/**
 * 用户业务接口
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface UserService
{
    /**
     * 用户登录
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    UserLoginResp userLogin(UserLoginReq req, HttpSession session)
        throws InnerException;
    
    /**
     * 获取用户登录信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param req 获取用户登录信息请求体
     * @return 用户登录信息响应实体
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    UserLoginStateResp userLoginState(UserLoginStateReq req, HttpSession session)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    GetuserInfoResp getuserInfo(GetUserInfoReq req, HttpSession session)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    UpdateuserInfoResp updateUserinfo(UpdateUserInfoReq req, HttpSession session)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    BaseResponse updateUserHeadPic(UpdateHeadPicReq req, HttpSession session)
        throws Exception;
}
