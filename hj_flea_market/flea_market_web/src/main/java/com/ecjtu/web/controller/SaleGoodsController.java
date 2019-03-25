/*
 * 文 件 名:  SaleGoodsController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月13日
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
import com.ecjtu.web.service.SaleGoodsService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@AOPLogAnnotation
@RestController
public class SaleGoodsController
{
    
    @Autowired
    private SaleGoodsService saleGoodsService;
    
    @RequestMapping(value = "/selectGoodsNum", method = RequestMethod.POST)
    public SelectGoodsNumResp selectGoodsTotal(@RequestBody SelectGoodsNumReq req)
        throws InnerException
    {
        return saleGoodsService.selectGoodsTotal(req);
    }
    
    @RequestMapping(value = "/selectGoodsList", method = RequestMethod.POST)
    public SelectGoodsListResp selectGoodsList(@RequestBody SelectGoodsListReq req)
        throws InnerException
    {
        return saleGoodsService.selectGoodsList(req);
    }
    
    @RequestMapping(value = "/goodsDetail", method = RequestMethod.POST)
    public SelectGoodsDetailResp selectGoodsDetail(@RequestBody SelectGoodsDetailReq req, HttpSession session)
        throws InnerException
    {
        return saleGoodsService.selectGoodsDetail(req, session);
    }
    
    @RequestMapping(value = "/submitSale", method = RequestMethod.POST)
    public BaseResponse saleGoods(@RequestBody SaleGoodsReq sale, HttpSession session)
        throws InnerException
    {
        return saleGoodsService.saleGoods(sale, session);
    }
    
    @RequestMapping(value = "/getUserSale", method = RequestMethod.POST)
    public GetUserSaleListResp getUserSaleList(@RequestBody GetUserSaleListReq req, HttpSession session)
        throws InnerException
    {
        return saleGoodsService.getUserSaleList(req, session);
    }
    
    @RequestMapping(value = "/getSaleReturn", method = RequestMethod.POST)
    public GetSaleReturnResp getSaleReturn(@RequestBody GetSaleReturnReq req, HttpSession session)
        throws InnerException
    {
        return saleGoodsService.getSaleReturn(req, session);
    }
    
    @RequestMapping(value = "/editSaleInfo", method = RequestMethod.POST)
    public EditSaleInfoResp editSaleInfo(@RequestBody EditSaleInfoReq req, HttpSession session)
        throws InnerException
    {
        return saleGoodsService.editSaleInfo(req, session);
    }
}
