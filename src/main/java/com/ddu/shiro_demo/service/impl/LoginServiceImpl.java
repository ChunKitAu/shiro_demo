package com.ddu.shiro_demo.service.impl;

import com.ddu.shiro_demo.bean.*;
import com.ddu.shiro_demo.dao.*;
import com.ddu.shiro_demo.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {

    UserDao userDao = new UserDao();
    RoleDao roleDao = new RoleDao();
    PermissionDao permissionDao = new PermissionDao();
    URoleDao uRoleDao = new URoleDao();
    RPermissionDao rPermissionDao = new RPermissionDao();


    @Override
    public User getUserByName(String getMapByName) {
        Set<User> users = userDao.getUsers();
        List<User> result = new ArrayList<>();
        for (User user:
             users) {
            if(user.getName().equals(getMapByName)){
                return userDao.getOne(user.getId());
            }
        }

        return null;

//        return getMapByName(getMapByName);
    }

    @Override
    public List<Role> getRoleByUserId(String usrId) {
        Set<URole> uRs = uRoleDao.getURs();
        List<Role> result = new ArrayList<>();
        for (URole ur:
             uRs) {
            if(ur.getUserId().equals(usrId)){
                result.add(roleDao.getOne(ur.getRoleId()));
            }
        }
        return result.isEmpty()?null:result;
    }

    //返回角色拥有的权限
    @Override
    public List<String> getPermissionByRoleId(String roleId) {
        List<String> result = new ArrayList<>();
        Set<RPermission> rPs = rPermissionDao.getRPs();
        for (RPermission rp:
                rPs) {
            if(rp.getRoleId().equals(roleId))
                result.add(permissionDao.getOne(rp.getPermissionId()).getName());
        }


        return result.isEmpty()?null:result;
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
