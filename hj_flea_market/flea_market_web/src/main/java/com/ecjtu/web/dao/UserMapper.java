/*
 * 文 件 名:  UserMapper.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ecjtu.common.model.User;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface UserMapper
{
    /**
     * 通过email查询用户信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param uEmail 用户邮箱
     * @return 用户信息实体
     * @see [类、类#方法、类#成员]
     */
    User selectUbyEmail(String uEmail);
    
    /**
     * 注册账号
     * <一句话功能简述>
     * <功能详细描述>
     * @param user 用户信息
     * @return 插入结果
     * @see [类、类#方法、类#成员]
     */
    int regist(User user);
    
    /**
     * 更新用户信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param user 用户信息
     * @return 更新结果
     * @see [类、类#方法、类#成员]
     */
    int updateUserInfo(User user);
    
    /**
     * 通过uId查询用户信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param id 用户id
     * @return 用户信息
     * @see [类、类#方法、类#成员]
     */
    User selectUbyId(int uId);
}
