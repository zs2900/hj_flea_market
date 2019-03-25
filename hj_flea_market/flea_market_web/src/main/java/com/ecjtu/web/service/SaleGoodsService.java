/*
 * 文 件 名:  SaleGoodsService.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月13日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service;

import javax.servlet.http.HttpSession;

import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.web.controller.req.EditSaleInfoReq;
import com.ecjtu.web.controller.req.GetSaleReturnReq;
import com.ecjtu.web.controller.req.GetUserSaleListReq;
import com.ecjtu.web.controller.req.SaleGoodsReq;
import com.ecjtu.web.controller.req.SelectGoodsDetailReq;
import com.ecjtu.web.controller.req.SelectGoodsListReq;
import com.ecjtu.web.controller.req.SelectGoodsNumReq;
import com.ecjtu.web.controller.resp.EditSaleInfoResp;
import com.ecjtu.web.controller.resp.GetSaleReturnResp;
import com.ecjtu.web.controller.resp.GetUserSaleListResp;
import com.ecjtu.web.controller.resp.SelectGoodsDetailResp;
import com.ecjtu.web.controller.resp.SelectGoodsListResp;
import com.ecjtu.web.controller.resp.SelectGoodsNumResp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface SaleGoodsService
{
    /**
     * 获取二手商品总数
     * <一句话功能简述>
     * <功能详细描述>
     * @param req 请求体
     * @return 二手商品总数
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    SelectGoodsNumResp selectGoodsTotal(SelectGoodsNumReq req)
        throws InnerException;
    
    /**
     * 获取二手商品列表
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    SelectGoodsListResp selectGoodsList(SelectGoodsListReq req)
        throws InnerException;
    
    /**
     * 获取商品详细信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    SelectGoodsDetailResp selectGoodsDetail(SelectGoodsDetailReq req, HttpSession session)
        throws InnerException;
    
    /**
     * 上传商品信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    BaseResponse saleGoods(SaleGoodsReq req, HttpSession session)
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
    GetUserSaleListResp getUserSaleList(GetUserSaleListReq req, HttpSession session)
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
    GetSaleReturnResp getSaleReturn(GetSaleReturnReq req, HttpSession session)
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
    EditSaleInfoResp editSaleInfo(EditSaleInfoReq req, HttpSession session)
        throws InnerException;
}
