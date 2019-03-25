/*
 * 文 件 名:  SaleGoodsManageReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller.req;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.PaginationBaseRequest;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SaleGoodsManageReq extends PaginationBaseRequest
{
    private Integer gState;
    
    //0为正序1为逆序
    private Integer sortByTime;
    
    /**
     * @return 返回 gState
     */
    public Integer getgState()
    {
        return gState;
    }
    
    /**
     * @param 对gState进行赋值
     */
    public void setgState(Integer gState)
    {
        this.gState = gState;
    }
    
    /**
     * @return 返回 sortByTime
     */
    public Integer getSortByTime()
    {
        return sortByTime;
    }
    
    /**
     * @param 对sortByTime进行赋值
     */
    public void setSortByTime(Integer sortByTime)
    {
        this.sortByTime = sortByTime;
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
