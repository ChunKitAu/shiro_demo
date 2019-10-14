package com.ddu.shiro_demo.dao;

import com.ddu.shiro_demo.bean.URole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class URoleDaoTest extends BaseTest {

    @Autowired
    private URoleDao uRoleDao;

    @Test
    public void testGetURs(){
        for (URole ur :
                uRoleDao.getURs()) {
            System.out.println(ur);
        }
    }

    @Test
    public void testGetOne(){
        System.out.println(uRoleDao.getOne(1));
    }

}
