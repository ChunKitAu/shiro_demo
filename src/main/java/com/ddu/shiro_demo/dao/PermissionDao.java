package com.ddu.shiro_demo.dao;

import com.ddu.shiro_demo.bean.Permission;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionDao {

    static List<Permission> db;

    static {
        db = new ArrayList<>();
        db.add(new Permission("p001","add"));
        db.add(new Permission("p002","delete"));
        db.add(new Permission("p003","update"));
        db.add(new Permission("p004","select"));
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    public List<Permission> getPermissions(){
        return db;
    }

    /**
     * 单条查询
     *
     * @param id 权限id
     * @return
     */
    public Permission getOne(String id) {
        for (Permission permission : db) {
            if (permission.getId().equals(id)) {
                return permission;
            }
        }
        return null;
    }
}
