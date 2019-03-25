package com.ecjtu.flea_market_server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecjtu.flea_market_server.bean.resp.SelectGoodsAdmin;
import com.ecjtu.flea_market_server.controller.req.ExamineGoodsReq;
import com.ecjtu.flea_market_server.controller.req.SaleGoodsInfoReq;
import com.ecjtu.flea_market_server.controller.req.SaleGoodsManageReq;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface SaleGoodsMapper
{
    /**
     * 查询商品
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<SelectGoodsAdmin> SelectGoodsByParam(SaleGoodsManageReq req);
    
    /**
     * 查询商品总数
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer SelectGoodsByParamNum(SaleGoodsManageReq req);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    SelectGoodsAdmin selectGoodsInfo(SaleGoodsInfoReq req);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer ExamimeGoods(ExamineGoodsReq req);
}
