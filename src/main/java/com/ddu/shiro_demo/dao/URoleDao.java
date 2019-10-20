package com.ddu.shiro_demo.dao;

import com.ddu.shiro_demo.bean.URole;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.HashSet;

@Component
public class URoleDao {

    static Set<URole> db;

    static {
        db = new HashSet<>();
        /*
        u001 身份为 admin
        u002 身份为 guest
        u003 身份为 guest
         */
        db.add(new URole(1, "r001", "u001"));
        db.add(new URole(2, "r002", "u002"));
        db.add(new URole(3, "r002", "u003"));
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    public Set<URole> getURs() {
        return db;
    }

    /**
     * 单条查询
     *
     * @param id 中间表id
     * @return
     */
    public URole getOne(Integer id) {
        for (URole ur :
                db) {
            if (ur.getId() == id) {
                return ur;
            }
        }
        return null;
    }

}
