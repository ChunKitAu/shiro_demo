package com.ddu.shiro_demo.service.impl;

import com.ddu.shiro_demo.bean.Permission;
import com.ddu.shiro_demo.bean.Role;
import com.ddu.shiro_demo.bean.User;
import com.ddu.shiro_demo.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public User getUserByName(String getMapByName) {
        return getMapByName(getMapByName);
    }

    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
    private User getMapByName(String userName){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
//        Permission permission1 = new Permission("1","query");
//        Permission permission2 = new Permission("2","add");
//        Set<Permission> permissionsSet = new HashSet<>();
//        permissionsSet.add(permission1);
//        permissionsSet.add(permission2);
//        Role role = new Role("1","admin",permissionsSet);
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(role);
//        User user = new User("1","wsl","123456",roleSet);
//        Map<String ,User> map = new HashMap<>();
//        map.put(user.getName(), user);
//
//        Permission permissions3 = new Permission("3","query");
//        Set<Permission> permissionsSet1 = new HashSet<>();
//        permissionsSet1.add(permissions3);
//        Role role1 = new Role("2","user",permissionsSet1);
//        Set<Role> roleSet1 = new HashSet<>();
//        roleSet1.add(role1);
//        User user1 = new User("2","zhangsan","123456",roleSet1);
//        map.put(user1.getName(), user1);
//        return map.get(userName);
        return null;
    }
}
