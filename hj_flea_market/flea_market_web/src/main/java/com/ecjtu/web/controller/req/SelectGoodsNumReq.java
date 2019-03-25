/*
 * 文 件 名:  SelectGoodsNumReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月13日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.req;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.PaginationBaseRequest;
import com.ecjtu.common.validator.annotations.Location;
import com.ecjtu.common.validator.annotations.Param;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "")
public class SelectGoodsNumReq extends PaginationBaseRequest
{
    private String gName;
    
    private Integer sortByPrice;
    
    private Integer gId;
    
    private Integer sortByTime;
    
    private String gAddress;
    
    private String gType;
    
    private Integer gState;
    
    /**
     * @return 返回 gName
     */
    @Param(canBlank = true)
    public String getgName()
    {
        return gName;
    }
    
    /**
     * @param 对gName进行赋值
     */
    public void setgName(String gName)
    {
        this.gName = gName;
    }
    
    /**
     * @return 返回 sortByPrice
     */
    @Param(canBlank = true)
    public Integer getSortByPrice()
    {
        return sortByPrice;
    }
    
    /**
     * @param 对sortByPrice进行赋值
     */
    public void setSortByPrice(Integer sortByPrice)
    {
        this.sortByPrice = sortByPrice;
    }
    
    /**
     * @return 返回 gId
     */
    @Param(canBlank = true)
    public Integer getgId()
    {
        return gId;
    }
    
    /**
     * @param 对gId进行赋值
     */
    public void setgId(Integer gId)
    {
        this.gId = gId;
    }
    
    /**
     * @return 返回 sortByTime
     */
    @Param(canBlank = true)
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
     * @return 返回 gAddress
     */
    @Param(canBlank = true)
    public String getgAddress()
    {
        return gAddress;
    }
    
    /**
     * @param 对gAddress进行赋值
     */
    public void setgAddress(String gAddress)
    {
        this.gAddress = gAddress;
    }
    
    /**
     * @return 返回 gType
     */
    @Param(canBlank = true)
    public String getgType()
    {
        return gType;
    }
    
    /**
     * @param 对gType进行赋值
     */
    public void setgType(String gType)
    {
        this.gType = gType;
    }
    
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
