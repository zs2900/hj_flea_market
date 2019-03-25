/*
 * 文 件 名:  FavoritesMappper.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月17日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecjtu.web.bean.Favorites;
import com.ecjtu.web.bean.resp.SelectFavorites;
import com.ecjtu.web.controller.req.GetUserFavoritesReq;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface FavoritesMappper
{
    /**
     * 添加到收藏夹
     * <一句话功能简述>
     * <功能详细描述>
     * @param favorites 收藏商品信息
     * @return 添加结果
     * @see [类、类#方法、类#成员]
     */
    Integer addToFavorites(Favorites favorites);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param uId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer getUserFavoritesNum(Integer uId);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<SelectFavorites> getUserFavoritesList(GetUserFavoritesReq req);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param fId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer deleteFavorites(Integer fId);
}
