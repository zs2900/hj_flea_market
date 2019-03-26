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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.exception.ValidateException;
import com.ecjtu.common.model.Display;
import com.ecjtu.common.validator.Validator;
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
    
    @Value("${file.service.uri}")
    private String imageRoot;
    
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
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public DisplayListResp selectDisplay(DisplayListReq req)
        throws InnerException
    {
        Validator.getInstance().validate(DisplayListReq.class, req);
        
        List<Display> list = displayMapper.selectDisplayList(req);
        Integer totalItem = displayMapper.selectDisplayListNum(req);
        DisplayListResp resp = new DisplayListResp();
        resp.setDisplays(list);
        resp.setTotalItem(totalItem);
        resp.setImageRoot(imageRoot);
        return resp;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public DisplayStartResp startDisplay(DisplayStartReq req)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(DisplayStartReq.class, req);
        
        Display display = new Display();
        display.setdId(req.getdId());
        display.setdState(req.getdState());
        displayMapper.editDisplay(display);
        return new DisplayStartResp();
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param dId
     * @return
     * @throws InnerException 
     * @throws ValidateException 
     * @see [类、类#方法、类#成员]
     */
    @Override
    public DisplayEditReturnResp selectDisplayById(DisplayEditReturnReq req)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(DisplayEditReturnReq.class, req);
        
        Display display = displayMapper.selectDisplayById(req.getdId());
        DisplayEditReturnResp resp = new DisplayEditReturnResp();
        resp.setDisplay(display);
        resp.setImageRoot(imageRoot);
        return resp;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public DisplayEditResp editDisplay(DisplayEditReq req)
        throws InnerException
    {
        Validator.getInstance().validate(DisplayEditReq.class, req);
        
        Display display = new Display();
        display.setdId(req.getdId());
        display.setdImg(req.getdImg());
        display.setgId(req.getgId());
        display.setdState(req.getdState());
        displayMapper.editDisplay(display);
        return new DisplayEditResp();
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public DisplayDeleteResp deleteDisplay(DisplayDeleteReq req)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(DisplayDeleteReq.class, req);
        
        displayMapper.deleteDisPlay(req.getdId());
        return new DisplayDeleteResp();
    }
    
}
