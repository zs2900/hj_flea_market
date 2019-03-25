/*
 * 文 件 名:  SelectGoodsNumResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月13日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.resp;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.response.BaseResponse;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SelectGoodsNumResp extends BaseResponse
{
    private Integer goodsNum;
    
    private Integer pageSize;
    
    /**
     * @return 返回 goodsNum
     */
    public Integer getGoodsNum()
    {
        return goodsNum;
    }
    
    /**
     * @param 对goodsNum进行赋值
     */
    public void setGoodsNum(Integer goodsNum)
    {
        this.goodsNum = goodsNum;
    }
    
    /**
     * @return 返回 pageSize
     */
    public Integer getPageSize()
    {
        return pageSize;
    }
    
    /**
     * @param 对pageSize进行赋值
     */
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
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
