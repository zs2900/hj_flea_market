/*
 * 文 件 名:  FavoritesController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月17日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
import com.ecjtu.web.controller.req.AddToFavoritesReq;
import com.ecjtu.web.controller.req.DeleteFavoritesReq;
import com.ecjtu.web.controller.req.GetUserFavoritesReq;
import com.ecjtu.web.controller.resp.GetUserFavoritesResp;
import com.ecjtu.web.service.FavoritesService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@AOPLogAnnotation
@RestController
public class FavoritesController
{
    @Autowired
    private FavoritesService favoritesService;
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/addToFavorites", method = RequestMethod.POST)
    public BaseResponse addToFavorites(@RequestBody AddToFavoritesReq req, HttpSession session)
        throws InnerException
    {
        BaseResponse resp = favoritesService.addToFavorites(req, session);
        return resp;
    }
    
    @RequestMapping(value = "/getUserFavorites", method = RequestMethod.POST)
    public GetUserFavoritesResp getUserFavorites(@RequestBody GetUserFavoritesReq req, HttpSession session)
        throws InnerException
    {
        GetUserFavoritesResp resp = favoritesService.getUserFavorites(req, session);
        return resp;
    }
    
    @RequestMapping(value = "/deleteFavorites", method = RequestMethod.POST)
    public BaseResponse DeleteFavorites(@RequestBody DeleteFavoritesReq req, HttpSession session)
        throws InnerException
    {
        BaseResponse resp = favoritesService.deleteFavorites(req, session);
        return resp;
    }
}
