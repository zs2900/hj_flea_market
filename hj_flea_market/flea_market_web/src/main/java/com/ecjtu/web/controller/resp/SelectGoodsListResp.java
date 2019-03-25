/*
 * 文 件 名:  SelectGoodsListResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月13日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.resp;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.web.bean.resp.SelectGoods;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SelectGoodsListResp extends BaseResponse
{
    private List<SelectGoods> goodsList;
    
    /**
     * @return 返回 goodsList
     */
    public List<SelectGoods> getGoodsList()
    {
        return goodsList;
    }
    
    /**
     * @param 对goodsList进行赋值
     */
    public void setGoodsList(List<SelectGoods> goodsList)
    {
        this.goodsList = goodsList;
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
