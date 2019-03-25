package com.ecjtu.flea_market_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
import com.ecjtu.flea_market_server.controller.req.ExamineGoodsReq;
import com.ecjtu.flea_market_server.controller.req.SaleGoodsInfoReq;
import com.ecjtu.flea_market_server.controller.req.SaleGoodsManageReq;
import com.ecjtu.flea_market_server.controller.resp.ExamineGoodsResp;
import com.ecjtu.flea_market_server.controller.resp.SaleGoodsInfoResp;
import com.ecjtu.flea_market_server.controller.resp.SaleGoodsManageResp;
import com.ecjtu.flea_market_server.service.SaleGoodsManageService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@AOPLogAnnotation
@RestController
public class SaleGoodsMangeController
{
    @Autowired
    private SaleGoodsManageService saleGoodsManageService;
    
    @RequestMapping(value = "/manageSale", method = RequestMethod.POST)
    public SaleGoodsManageResp getSaleList(@RequestBody SaleGoodsManageReq req)
        throws InnerException
    {
        return saleGoodsManageService.getSaleGoodsList(req);
    }
    
    @RequestMapping(value = "/getGoodsInfo", method = RequestMethod.POST)
    public SaleGoodsInfoResp getSaleGoods(@RequestBody SaleGoodsInfoReq req)
        throws InnerException
    {
        return saleGoodsManageService.getSaleGoodsInfo(req);
    }
    
    @RequestMapping(value = "/examineGoods", method = RequestMethod.POST)
    public ExamineGoodsResp examineGoods(@RequestBody ExamineGoodsReq req)
        throws InnerException
    {
        return saleGoodsManageService.examineGoods(req);
    }
}
