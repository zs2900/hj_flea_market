/*
 * 文 件 名:  AdminMapper.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ecjtu.flea_market_server.bean.Admin;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface AdminMapper
{
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param userName
     * @param password
     * @return
     * @see [类、类#方法、类#成员]
     */
    Admin getAdmin(@Param("username") String userName, @Param("password") String password);
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param name
     * @return
     * @see [类、类#方法、类#成员]
     */
    Admin getAdminByName(String name);
}
