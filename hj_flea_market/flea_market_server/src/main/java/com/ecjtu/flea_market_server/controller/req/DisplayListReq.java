/*
 * 文 件 名:  DisplayListReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月26日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.controller.req;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.PaginationBaseRequest;
import com.ecjtu.common.validator.annotations.Location;
import com.ecjtu.common.validator.annotations.Param;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月26日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "")
public class DisplayListReq extends PaginationBaseRequest
{
    private Integer dState;
    
    /**
     * @return 返回 dState
     */
    @Param(canBlank = true)
    public Integer getdState()
    {
        return dState;
    }
    
    /**
     * @param 对dState进行赋值
     */
    public void setdState(Integer dState)
    {
        this.dState = dState;
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
