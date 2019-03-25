/*
 * 文 件 名:  GoodsMessageController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月15日
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

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
import com.ecjtu.web.controller.req.SelectGoodsMessageReq;
import com.ecjtu.web.controller.req.SendMessageReq;
import com.ecjtu.web.controller.resp.SelectGoodsMessageResp;
import com.ecjtu.web.controller.resp.SendMessageResp;
import com.ecjtu.web.service.MessageService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月15日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@AOPLogAnnotation
@RestController
public class GoodsMessageController
{
    @Autowired
    private MessageService messageService;
    
    @RequestMapping(value = "/goodsMsg", method = RequestMethod.POST)
    public SelectGoodsMessageResp selectGoodsMessages(@RequestBody SelectGoodsMessageReq req)
        throws InnerException
    {
        SelectGoodsMessageResp resp = messageService.selectGoodsmessages(req);
        return resp;
    }
    
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    public SendMessageResp sendMessage(@RequestBody SendMessageReq req, HttpSession session)
        throws InnerException
    {
        SendMessageResp resp = messageService.saveMessage(req, session);
        return resp;
    }
}
