package com.ddu.shiro_demo.dao;

import com.ddu.shiro_demo.bean.RPermission;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.HashSet;

@Component
public class RPermissionDao {

    static Set<RPermission> db;

    static {
        db = new HashSet<>();
        /**
         * admin 拥有 add delete update select权限
         */
        db.add(new RPermission(1, "r001", "p001"));
        db.add(new RPermission(2, "r001", "p002"));
        db.add(new RPermission(3, "r001", "p003"));
        db.add(new RPermission(4, "r001", "p004"));

        /**
         * guest 拥有 add select权限
         */
        db.add(new RPermission(5, "r002", "p001"));
        db.add(new RPermission(6, "r002", "p004"));
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    public Set<RPermission> getRPs() {
        return db;
    }

    /**
     * 单条查询
     *
     * @param id 中间表id
     * @return
     */
    public RPermission getOne(Integer id) {
        for (RPermission rPermission : db) {
            if (rPermission.getId() == id) {
                return rPermission;
            }
        }
        return null;
    }

}
