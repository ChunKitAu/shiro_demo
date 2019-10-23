package com.ddu.shiro_demo.service;

import com.ddu.shiro_demo.bean.Permission;
import com.ddu.shiro_demo.bean.Role;
import com.ddu.shiro_demo.bean.User;

import java.util.List;

public interface LoginService {

    User getUserByName(String getMapByName);

    List<Role> getRoleByUserId(String usrId);

    List<String> getPermissionByRoleId(String roleId);



}
