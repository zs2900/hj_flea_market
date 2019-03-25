/*
 * 文 件 名:  UserServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecjtu.flea_market_server.bean.Admin;
import com.ecjtu.flea_market_server.dao.AdminMapper;
import com.ecjtu.flea_market_server.service.UserService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private AdminMapper adminMapper;
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param name
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Override
    public Admin getAdmin(String name)
    {
        return adminMapper.getAdminByName(name);
    }
    
}
