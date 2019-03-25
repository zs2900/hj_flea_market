/*
 * 文 件 名:  SaleGoodsManageServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.flea_market_server.bean.resp.SelectGoodsAdmin;
import com.ecjtu.flea_market_server.controller.req.ExamineGoodsReq;
import com.ecjtu.flea_market_server.controller.req.SaleGoodsInfoReq;
import com.ecjtu.flea_market_server.controller.req.SaleGoodsManageReq;
import com.ecjtu.flea_market_server.controller.resp.ExamineGoodsResp;
import com.ecjtu.flea_market_server.controller.resp.SaleGoodsInfoResp;
import com.ecjtu.flea_market_server.controller.resp.SaleGoodsManageResp;
import com.ecjtu.flea_market_server.dao.SaleGoodsMapper;
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
@Service
public class SaleGoodsManageServiceImpl implements SaleGoodsManageService
{
    @Autowired
    private SaleGoodsMapper saleGoodsMapper;
    
    @Value("${file.service.uri}")
    private String imageRoot;
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public SaleGoodsManageResp getSaleGoodsList(SaleGoodsManageReq req)
        throws InnerException
    {
        Validator.getInstance().validate(SaleGoodsManageReq.class, req);
        
        List<SelectGoodsAdmin> list = saleGoodsMapper.SelectGoodsByParam(req);
        int total = saleGoodsMapper.SelectGoodsByParamNum(req);
        SaleGoodsManageResp resp = new SaleGoodsManageResp();
        resp.setTotal(total);
        resp.setGoods(list);
        resp.setImageRoot(imageRoot);
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
    public SaleGoodsInfoResp getSaleGoodsInfo(SaleGoodsInfoReq req)
        throws InnerException
    {
        Validator.getInstance().validate(SaleGoodsInfoReq.class, req);
        
        SelectGoodsAdmin goods = saleGoodsMapper.selectGoodsInfo(req);
        SaleGoodsInfoResp resp = new SaleGoodsInfoResp();
        resp.setGoodsInfo(goods);
        resp.setImageRoot(imageRoot);
        
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
    public ExamineGoodsResp examineGoods(ExamineGoodsReq req)
        throws InnerException
    {
        Validator.getInstance().validate(ExamineGoodsReq.class, req);
        
        saleGoodsMapper.ExamimeGoods(req);
        
        return new ExamineGoodsResp();
    }
    
}
