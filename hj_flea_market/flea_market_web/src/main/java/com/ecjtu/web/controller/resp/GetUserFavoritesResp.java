/*
 * 文 件 名:  GetUserFavoritesResp.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月18日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.resp;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.web.bean.resp.SelectFavorites;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月18日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class GetUserFavoritesResp extends BaseResponse
{
    private List<SelectFavorites> favoritesList;
    
    private Integer totalPage;
    
    /**
     * @return 返回 favoritesList
     */
    public List<SelectFavorites> getFavoritesList()
    {
        return favoritesList;
    }
    
    /**
     * @param 对favoritesList进行赋值
     */
    public void setFavoritesList(List<SelectFavorites> favoritesList)
    {
        this.favoritesList = favoritesList;
    }
    
    /**
     * @return 返回 totalPage
     */
    public Integer getTotalPage()
    {
        return totalPage;
    }
    
    /**
     * @param 对totalPage进行赋值
     */
    public void setTotalPage(Integer totalPage)
    {
        this.totalPage = totalPage;
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
