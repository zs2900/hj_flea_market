/*
 * 文 件 名:  MessageServcieImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月15日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.web.bean.resp.SelectMessage;
import com.ecjtu.web.controller.req.SelectGoodsMessageReq;
import com.ecjtu.web.controller.req.SendMessageReq;
import com.ecjtu.web.controller.resp.SelectGoodsMessageResp;
import com.ecjtu.web.controller.resp.SendMessageResp;
import com.ecjtu.web.dao.MessageMapper;
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
@Service
public class MessageServcieImpl implements MessageService
{
    @Autowired
    private MessageMapper messageMapper;
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public SelectGoodsMessageResp selectGoodsmessages(SelectGoodsMessageReq req)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(SelectGoodsMessageReq.class, req);
        
        SelectGoodsMessageResp resp = new SelectGoodsMessageResp();
        List<SelectMessage> messages = messageMapper.selectGoodsMessages(req);
        resp.setMessages(messages);
        Integer total = messageMapper.selectMessageNum(req.getgId());
        Integer totalPage = total % req.getPageSize() == 0 ? total / req.getPageSize() : total / req.getPageSize() + 1;
        resp.setTotalPage(totalPage);
        return resp;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public SendMessageResp saveMessage(SendMessageReq req, HttpSession session)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(SendMessageReq.class, req);
        
        if (session.getAttribute("userAccount") == null)
        {
            SendMessageResp resp = new SendMessageResp();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg("请登录后在留言");
        }
        
        messageMapper.saveMessage(req);
        
        SendMessageResp resp = new SendMessageResp();
        resp.setRetCode(ResultCode.SUCCESS.getResultCode());
        resp.setRetMsg(ResultCode.SUCCESS.getResultMsg());
        
        return resp;
    }
    
}
