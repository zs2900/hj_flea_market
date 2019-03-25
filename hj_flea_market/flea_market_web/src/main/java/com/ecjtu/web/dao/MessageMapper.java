/*
 * 文 件 名:  MessageMapper.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月15日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.web.bean.resp.SelectMessage;
import com.ecjtu.web.controller.req.SelectGoodsMessageReq;
import com.ecjtu.web.controller.req.SendMessageReq;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月15日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface MessageMapper
{
    /**
     * 查询商品的留言
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    List<SelectMessage> selectGoodsMessages(SelectGoodsMessageReq req);
    
    /**
     * 查询商品的留言总数
     * <一句话功能简述>
     * <功能详细描述>
     * @param gId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer selectMessageNum(Integer gId);
    
    /**
     * 保存留言信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer saveMessage(SendMessageReq req);
}
