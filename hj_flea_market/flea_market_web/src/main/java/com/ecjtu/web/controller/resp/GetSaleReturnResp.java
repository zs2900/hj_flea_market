/*
 * 文 件 名:  GetSaleReturnResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月19日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.resp;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.web.bean.resp.SelectGoods;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class GetSaleReturnResp extends BaseResponse
{
    private SelectGoods goods;
    
    /**
     * @return 返回 goods
     */
    public SelectGoods getGoods()
    {
        return goods;
    }
    
    /**
     * @param 对goods进行赋值
     */
    public void setGoods(SelectGoods goods)
    {
        this.goods = goods;
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
