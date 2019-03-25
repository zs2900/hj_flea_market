/*
 * 文 件 名:  MyShiroRealm.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月21日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.flea_market_server.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecjtu.flea_market_server.bean.Admin;
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
public class MyShiroRealm extends AuthorizingRealm
{
    @Autowired
    private UserService userService;
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param arg0
     * @return
     * @see [类、类#方法、类#成员]
     */
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     * @see [类、类#方法、类#成员]
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
        throws AuthenticationException
    {
        
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null)
        {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        Admin user = userService.getAdmin(name);
        if (user == null)
        {
            //这里返回后会报出对应异常
            return null;
        }
        else
        {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(name, user.getaPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param arg0
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        //添加角色和权限
        List<String> permissions = new ArrayList<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }
    
}
