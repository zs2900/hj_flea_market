/*
 * 文 件 名:  IResponse.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.controller.response;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface IResponse
{
    /**
     * 获取返回码
     * <功能详细描述>
     * @return 错误码
     * @see [类、类#方法、类#成员]
     */
    int getRetCode();
    
    /**
     * 设置返回码
     * <功能详细描述>
     * @param retCode 错误码
     * @see [类、类#方法、类#成员]
     */
    void setRetCode(int retCode);
    
    /**
     * 获取返回信息
     * <功能详细描述>
     * @return 错误消息
     * @see [类、类#方法、类#成员]
     */
    String getRetMsg();
    
    /**
     * 设置返回信息
     * <功能详细描述>
     * @param retMsg 错误消息
     * @see [类、类#方法、类#成员]
     */
    void setRetMsg(String retMsg);
}
