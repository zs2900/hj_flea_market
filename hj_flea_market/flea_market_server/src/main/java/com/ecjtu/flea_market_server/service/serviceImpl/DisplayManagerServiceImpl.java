/*
 * 文 件 名:  DisplayManagerServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.flea_market_server.controller.req.DisplayManagerReq;
import com.ecjtu.flea_market_server.controller.resp.DisplayManagerResp;
import com.ecjtu.flea_market_server.dao.DisplayMapper;
import com.ecjtu.flea_market_server.service.DisplayManagerService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class DisplayManagerServiceImpl implements DisplayManagerService
{
    @Autowired
    private DisplayMapper displayMapper;
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public DisplayManagerResp addDisplay(DisplayManagerReq req)
        throws InnerException
    {
        Validator.getInstance().validate(DisplayManagerReq.class, req);
        
        displayMapper.addDisplay(req);
        return new DisplayManagerResp();
    }
    
}
