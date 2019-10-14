package com.ddu.shiro_demo.dao;

import com.ddu.shiro_demo.bean.Permission;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PermissionDaoTest extends BaseTest {

    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void testGetPermissions(){
        for (Permission permission : permissionDao.getPermissions()) {
            System.out.println(permission);
        }
    }

    @Test
    public void testGetOne(){
        String id = "p001";
//        String id = "r006";
        System.out.println(permissionDao.getOne(id));
    }

}
