/*
 * 文 件 名:  UserController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月7日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
import com.ecjtu.web.controller.req.GetUserInfoReq;
import com.ecjtu.web.controller.req.UpdateHeadPicReq;
import com.ecjtu.web.controller.req.UpdateUserInfoReq;
import com.ecjtu.web.controller.resp.GetuserInfoResp;
import com.ecjtu.web.controller.resp.UpdateuserInfoResp;
import com.ecjtu.web.service.UserService;

/**
 * 用户请求控制类
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@AOPLogAnnotation
@RestController
public class UserController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public GetuserInfoResp getuserInfo(@RequestBody GetUserInfoReq req, HttpSession session)
        throws InnerException
    {
        return userService.getuserInfo(req, session);
    }
    
    @RequestMapping(value = "/updateUserinfo", method = RequestMethod.POST)
    public UpdateuserInfoResp updateUserInfo(@RequestBody UpdateUserInfoReq req, HttpSession session)
        throws InnerException
    {
        return userService.updateUserinfo(req, session);
    }
    
    @RequestMapping(value = "/updateHeadPic", method = RequestMethod.POST)
    public BaseResponse updateUserHeadPic(@RequestBody UpdateHeadPicReq req, HttpSession session)
        throws Exception
    {
        return userService.updateUserHeadPic(req, session);
    }
}
