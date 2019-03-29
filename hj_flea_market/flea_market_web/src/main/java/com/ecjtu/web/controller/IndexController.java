/*
 * 文 件 名:  IndexController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class IndexController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String forall()
    {
        return "index";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }
    
    @RequestMapping(value = "/sale", method = RequestMethod.GET)
    public String sale()
    {
        return "sale";
    }
    
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }
    
    @RequestMapping(value = "/registerPage", method = RequestMethod.GET)
    public String regist()
    {
        return "register";
    }
    
    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public String loginOut(HttpSession session)
    {
        session.invalidate();
        return "login";
    }
    
    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public String goodsDetial()
    {
        return "goods";
    }
    
    @RequestMapping(value = "/salegoods", method = RequestMethod.GET)
    public String saleGoods()
    {
        return "saleGoods";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user()
    {
        return "user";
    }
    
    @RequestMapping(value = "/editSalePage", method = RequestMethod.GET)
    public String editSale()
    {
        return "editSale";
    }
}
