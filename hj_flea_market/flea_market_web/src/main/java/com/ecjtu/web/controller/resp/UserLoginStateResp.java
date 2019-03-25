/*
 * 文 件 名:  UserLoginStateResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月12日
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
 * @version  [版本号, 2019年3月12日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class UserLoginStateResp extends BaseResponse
{
    private Integer uId;
    
    private String uName;
    
    private String headPic;
    
    /**
     * @return 返回 uId
     */
    public Integer getuId()
    {
        return uId;
    }
    
    /**
     * @param 对uId进行赋值
     */
    public void setuId(Integer uId)
    {
        this.uId = uId;
    }
    
    /**
     * @return 返回 uName
     */
    public String getuName()
    {
        return uName;
    }
    
    /**
     * @param 对uName进行赋值
     */
    public void setuName(String uName)
    {
        this.uName = uName;
    }
    
    /**
     * @return 返回 headPic
     */
    public String getHeadPic()
    {
        return headPic;
    }
    
    /**
     * @param 对headPic进行赋值
     */
    public void setHeadPic(String headPic)
    {
        this.headPic = headPic;
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
