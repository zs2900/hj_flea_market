/*
 * 文 件 名:  DisplayMapper.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecjtu.common.model.Display;
import com.ecjtu.flea_market_server.controller.req.DisplayListReq;
import com.ecjtu.flea_market_server.controller.req.DisplayManagerReq;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface DisplayMapper
{
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer addDisplay(DisplayManagerReq req);
    
    /**
     * 查询展示列表
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<Display> selectDisplayList(DisplayListReq req);
    
    /**
     * 查询总数
     * <一句话功能简述>
     * <功能详细描述>
     * @param dState
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer selectDisplayListNum(DisplayListReq req);
    
    /**
     * 编辑展示栏
     * <一句话功能简述>
     * <功能详细描述>
     * @param display
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer editDisplay(Display display);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param dId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Display selectDisplayById(Integer dId);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param dId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer deleteDisPlay(Integer dId);
}
