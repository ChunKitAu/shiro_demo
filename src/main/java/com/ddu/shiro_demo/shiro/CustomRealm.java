package com.ddu.shiro_demo.shiro;

import com.ddu.shiro_demo.bean.Permission;
import com.ddu.shiro_demo.bean.Role;
import com.ddu.shiro_demo.bean.URole;
import com.ddu.shiro_demo.bean.User;
import com.ddu.shiro_demo.dao.RoleDao;
import com.ddu.shiro_demo.dao.URoleDao;
import com.ddu.shiro_demo.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    /**
     * 提供用户信息返回权限信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        User user = loginService.getUserByName(name);

        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        List<Role> userRole = loginService.getRoleByUserId(user.getId());

        for (Role r:
                userRole) {
            roles.add(r.getName());

            for (String permission:
                    loginService.getPermissionByRoleId(r.getId()))
                         permissions.add(permission);

        }


        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();


        //调用数据库获取用户信息,这里是模拟
        User user = loginService.getUserByName(name);

        if (user == null) {
            //这里返回后会报出对应异常
            throw new UnknownAccountException();
        }
        //这里验证authenticationToken和simpleAuthenticationInfo的信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
        return simpleAuthenticationInfo;

    }



}
