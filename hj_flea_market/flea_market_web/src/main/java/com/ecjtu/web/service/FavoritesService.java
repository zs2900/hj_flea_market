/*
 * 文 件 名:  FavoritesService.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月17日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service;

import javax.servlet.http.HttpSession;

import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.web.controller.req.AddToFavoritesReq;
import com.ecjtu.web.controller.req.DeleteFavoritesReq;
import com.ecjtu.web.controller.req.GetUserFavoritesReq;
import com.ecjtu.web.controller.resp.GetUserFavoritesResp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface FavoritesService
{
    /**
     * 添加到收藏夹
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    BaseResponse addToFavorites(AddToFavoritesReq req, HttpSession session)
        throws InnerException;
    
    /**
     * 获取用户收藏商品列表
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    GetUserFavoritesResp getUserFavorites(GetUserFavoritesReq req, HttpSession session)
        throws InnerException;
    
    /**
     * 删除收藏夹
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    BaseResponse deleteFavorites(DeleteFavoritesReq req, HttpSession session)
        throws InnerException;
}
