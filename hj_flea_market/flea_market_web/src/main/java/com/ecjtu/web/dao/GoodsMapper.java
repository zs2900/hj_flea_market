/*
 * 文 件 名:  GoodsMapper.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecjtu.web.bean.Goods;
import com.ecjtu.web.bean.resp.SelectGoods;
import com.ecjtu.web.controller.req.GetUserSaleListReq;
import com.ecjtu.web.controller.req.SelectGoodsListReq;
import com.ecjtu.web.controller.req.SelectGoodsNumReq;
import com.ecjtu.web.controller.resp.SelectGoodsDetailResp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface GoodsMapper
{
    List<Goods> getGoodsAll();
    
    List<Goods> getGoodsByParam();
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer selectGoodsTotal(SelectGoodsNumReq req);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<SelectGoods> selectGoodsList(SelectGoodsListReq req);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    SelectGoodsDetailResp selectGoodsDetail(Integer gId);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param goods
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer saveGoods(Goods goods);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param uId
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<Goods> getUserSaleList(GetUserSaleListReq req);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param uId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer getUserSaleNum(Integer uId);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param gId
     * @return
     * @see [类、类#方法、类#成员]
     */
    SelectGoods getSaleReturn(Integer gId);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param goods
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer editSaleInfo(Goods goods);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param gId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Goods getGoodsById(Integer gId);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param gId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer getGoodsUid(Integer gId);
}
