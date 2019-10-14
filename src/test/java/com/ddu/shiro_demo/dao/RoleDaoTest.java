package com.ddu.shiro_demo.dao;

import com.ddu.shiro_demo.bean.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleDaoTest extends BaseTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testGetRoles(){
        for (Role role : roleDao.getRoles()) {
            System.out.println(role);
        }
    }

    @Test
    public void testGetOne(){
        String id = "r001";
//        String id = "r006";
        System.out.println(roleDao.getOne(id));
    }

}
