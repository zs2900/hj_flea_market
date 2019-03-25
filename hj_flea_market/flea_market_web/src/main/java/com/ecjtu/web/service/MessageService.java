/*
 * 文 件 名:  MessageService.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月15日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service;

import javax.servlet.http.HttpSession;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.web.controller.req.SelectGoodsMessageReq;
import com.ecjtu.web.controller.req.SendMessageReq;
import com.ecjtu.web.controller.resp.SelectGoodsMessageResp;
import com.ecjtu.web.controller.resp.SendMessageResp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月15日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface MessageService
{
    /**
     * 查询商品留言列表
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    SelectGoodsMessageResp selectGoodsmessages(SelectGoodsMessageReq req)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    SendMessageResp saveMessage(SendMessageReq req, HttpSession session)
        throws InnerException;
}
