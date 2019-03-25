/*
 * 文 件 名:  AdminController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
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
@RestController
public class AdminController
{
    @Autowired
    private AdminLoginService adminLoginService;
    
    @AOPLogAnnotation
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AdminLoginResp adminLogin(@RequestBody AdminLoginReq req)
        throws InnerException
    {
        System.out.println(req);
        AdminLoginResp resp = adminLoginService.adminLogin(req);
        return resp;
    }
}
