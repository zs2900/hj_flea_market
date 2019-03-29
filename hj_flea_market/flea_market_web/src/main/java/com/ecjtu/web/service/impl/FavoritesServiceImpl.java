/*
 * 文 件 名:  FavoritesServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月17日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.model.Favorites;
import com.ecjtu.common.model.Goods;
import com.ecjtu.common.model.User;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.web.bean.resp.SelectFavorites;
import com.ecjtu.web.controller.req.AddToFavoritesReq;
import com.ecjtu.web.controller.req.DeleteFavoritesReq;
import com.ecjtu.web.controller.req.GetUserFavoritesReq;
import com.ecjtu.web.controller.resp.GetUserFavoritesResp;
import com.ecjtu.web.dao.FavoritesMappper;
import com.ecjtu.web.dao.GoodsMapper;
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
@Service
public class FavoritesServiceImpl implements FavoritesService
{
    @Autowired
    private FavoritesMappper favoritesMappper;
    
    @Autowired
    private GoodsMapper goodsMapper;
    
    @Override
    public BaseResponse addToFavorites(AddToFavoritesReq req, HttpSession session)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(AddToFavoritesReq.class, req);
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            BaseResponse response = new BaseResponse();
            response.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            response.setRetMsg("没有登录是无法收藏的呦！");
            return response;
        }
        
        Goods goods = goodsMapper.getGoodsById(req.getgId());
        //判断是否为空
        if (goods == null)
        {
            return new BaseResponse(ResultCode.DATA_NOT_EXIST.getResultCode(),
                ResultCode.DATA_NOT_EXIST.getResultMsg());
        }
        //判断是否是自己的商品
        if (goods.getuId().equals(user.getuId()))
        {
            BaseResponse response = new BaseResponse();
            response.setRetCode(ResultCode.INVALID_PARAM.getResultCode());
            response.setRetMsg("这是自己的商品呦！");
            return response;
        }
        Favorites favorites = new Favorites();
        favorites.setgId(req.getgId());
        favorites.setuId(user.getuId());
        //是否删除：1为删除，0为不删除
        favorites.setfIsDelete(0);
        favoritesMappper.addToFavorites(favorites);
        
        return new BaseResponse();
    }
    
    @Override
    public GetUserFavoritesResp getUserFavorites(GetUserFavoritesReq req, HttpSession session)
        throws InnerException
    {
        //验证用户是否登录
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            GetUserFavoritesResp resp = new GetUserFavoritesResp();
            resp.setRetCode(ResultCode.SUCCESS.getResultCode());
            resp.setRetMsg(ResultCode.SUCCESS.getResultMsg());
            return resp;
        }
        //获取收藏夹总数
        Integer total = favoritesMappper.getUserFavoritesNum(user.getuId());
        //获取收藏夹列表
        req.setuId(user.getuId());
        List<SelectFavorites> list = favoritesMappper.getUserFavoritesList(req);
        GetUserFavoritesResp resp = new GetUserFavoritesResp();
        resp.setFavoritesList(list);
        resp.setTotalPage(total / req.getPageSize() + 1);
        resp.setRetCode(ResultCode.SUCCESS.getResultCode());
        resp.setRetMsg(ResultCode.SUCCESS.getResultMsg());
        
        return resp;
    }
    
    @Override
    public BaseResponse deleteFavorites(DeleteFavoritesReq req, HttpSession session)
        throws InnerException
    {
        //验证用户登录
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            BaseResponse resp = new BaseResponse();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return resp;
        }
        //删除收藏
        favoritesMappper.deleteFavorites(req.getfId());
        BaseResponse resp = new BaseResponse();
        resp.setRetCode(ResultCode.SUCCESS.getResultCode());
        resp.setRetMsg(ResultCode.SUCCESS.getResultMsg());
        
        return resp;
    }
    
}
