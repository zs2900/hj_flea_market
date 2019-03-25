/*
 * 文 件 名:  SaleGoodsManageService.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.service;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.flea_market_server.controller.req.ExamineGoodsReq;
import com.ecjtu.flea_market_server.controller.req.SaleGoodsInfoReq;
import com.ecjtu.flea_market_server.controller.req.SaleGoodsManageReq;
import com.ecjtu.flea_market_server.controller.resp.ExamineGoodsResp;
import com.ecjtu.flea_market_server.controller.resp.SaleGoodsInfoResp;
import com.ecjtu.flea_market_server.controller.resp.SaleGoodsManageResp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface SaleGoodsManageService
{
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    SaleGoodsManageResp getSaleGoodsList(SaleGoodsManageReq req)
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
    SaleGoodsInfoResp getSaleGoodsInfo(SaleGoodsInfoReq req)
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
    ExamineGoodsResp examineGoods(ExamineGoodsReq req)
        throws InnerException;
}
