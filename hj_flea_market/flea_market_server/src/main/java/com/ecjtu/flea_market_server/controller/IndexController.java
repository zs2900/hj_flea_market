/*
 * 文 件 名:  IndexController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月20日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月20日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class IndexController
{
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }
    
    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }
    
    @RequestMapping(value = "/examinegoods", method = RequestMethod.GET)
    public String examinegoodsPage()
    {
        return "member-add";
    }
    
}
