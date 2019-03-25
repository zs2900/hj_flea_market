/*
 * 文 件 名:  BaseResponse.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.controller.response;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class BaseResponse implements IResponse
{
    
    private int retCode;
    
    private String retMsg;
    
    /**
     * 异常<默认构造函数>
      * @param e 异常
     */
    public BaseResponse(InnerException e)
    {
        this.retCode = e.getErrorCode();
        this.retMsg = e.getErrorDesc();
    }
    
    /**
     * <默认构造函数>
      *
     */
    public BaseResponse()
    {
        this.retCode = ResultCode.SUCCESS.getResultCode();
        this.retMsg = ResultCode.SUCCESS.getResultMsg();
    }
    
    /**
     * <默认构造函数>
      * @param retCode 返回消息错误码
      * @param retMsg 错误消息
     */
    public BaseResponse(int retCode, String retMsg)
    {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    
    /**
     * <默认构造函数>
      * @param resultCode 错误消息枚举
     */
    public BaseResponse(ResultCode resultCode)
    {
        if (resultCode != null)
        {
            this.retCode = resultCode.getResultCode();
            this.retMsg = resultCode.getResultMsg();
        }
    }
    
    @Override
    public int getRetCode()
    {
        return this.retCode;
    }
    
    @Override
    public void setRetCode(int retCode)
    {
        this.retCode = retCode;
    }
    
    @Override
    public String getRetMsg()
    {
        return this.retMsg;
    }
    
    @Override
    public void setRetMsg(String retMsg)
    {
        this.retMsg = retMsg;
    }
    
    @JSONField(serialize = false)
    public boolean isSuccess()
    {
        return ResultCode.SUCCESS.getResultCode() == this.retCode;
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
