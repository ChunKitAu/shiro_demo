package com.ddu.shiro_demo.dao;

import com.ddu.shiro_demo.bean.RPermission;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RPermissionDaoTest extends BaseTest {

    @Autowired
    private RPermissionDao rPermissionDao;

    @Test
    public void testGetRPs(){
        for (RPermission rp :
                rPermissionDao.getRPs()) {
            System.out.println(rp);
        }
    }

    @Test
    public void testGetOne(){
        System.out.println(rPermissionDao.getOne(1));
    }

}
