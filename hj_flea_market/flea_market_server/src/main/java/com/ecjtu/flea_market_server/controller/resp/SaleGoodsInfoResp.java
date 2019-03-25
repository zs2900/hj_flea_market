/*
 * 文 件 名:  SaleGoodsInfoResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月22日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller.resp;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.flea_market_server.bean.resp.SelectGoodsAdmin;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SaleGoodsInfoResp extends BaseResponse
{
    private SelectGoodsAdmin goodsInfo;
    
    private String imageRoot;
    
    /**
     * @return 返回 goodsInfo
     */
    public SelectGoodsAdmin getGoodsInfo()
    {
        return goodsInfo;
    }
    
    /**
     * @param 对goodsInfo进行赋值
     */
    public void setGoodsInfo(SelectGoodsAdmin goodsInfo)
    {
        this.goodsInfo = goodsInfo;
    }
    
    /**
     * @return 返回 imageRoot
     */
    public String getImageRoot()
    {
        return imageRoot;
    }
    
    /**
     * @param 对imageRoot进行赋值
     */
    public void setImageRoot(String imageRoot)
    {
        this.imageRoot = imageRoot;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }
    
}
