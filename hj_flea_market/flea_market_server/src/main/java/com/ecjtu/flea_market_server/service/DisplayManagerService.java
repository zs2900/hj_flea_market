/*
 * 文 件 名:  DisplayManagerService.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.service;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.flea_market_server.controller.req.DisplayDeleteReq;
import com.ecjtu.flea_market_server.controller.req.DisplayEditReq;
import com.ecjtu.flea_market_server.controller.req.DisplayEditReturnReq;
import com.ecjtu.flea_market_server.controller.req.DisplayListReq;
import com.ecjtu.flea_market_server.controller.req.DisplayManagerReq;
import com.ecjtu.flea_market_server.controller.req.DisplayStartReq;
import com.ecjtu.flea_market_server.controller.resp.DisplayDeleteResp;
import com.ecjtu.flea_market_server.controller.resp.DisplayEditResp;
import com.ecjtu.flea_market_server.controller.resp.DisplayEditReturnResp;
import com.ecjtu.flea_market_server.controller.resp.DisplayListResp;
import com.ecjtu.flea_market_server.controller.resp.DisplayManagerResp;
import com.ecjtu.flea_market_server.controller.resp.DisplayStartResp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface DisplayManagerService
{
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    DisplayManagerResp addDisplay(DisplayManagerReq req)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    DisplayListResp selectDisplay(DisplayListReq req)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    DisplayStartResp startDisplay(DisplayStartReq req)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    DisplayEditReturnResp selectDisplayById(DisplayEditReturnReq req)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    DisplayEditResp editDisplay(DisplayEditReq req)
        throws InnerException;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    DisplayDeleteResp deleteDisplay(DisplayDeleteReq req)
        throws InnerException;
}
