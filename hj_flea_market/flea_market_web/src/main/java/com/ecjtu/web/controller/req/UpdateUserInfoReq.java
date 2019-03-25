/*
 * 文 件 名:  UpdateUserInfoReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月18日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.req;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.BaseRequest;
import com.ecjtu.web.bean.User;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月18日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class UpdateUserInfoReq extends BaseRequest
{
    private User user;
    
    /**
     * @return 返回 user
     */
    public User getUser()
    {
        return user;
    }
    
    /**
     * @param 对user进行赋值
     */
    public void setUser(User user)
    {
        this.user = user;
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
