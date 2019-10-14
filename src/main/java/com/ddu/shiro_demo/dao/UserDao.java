package com.ddu.shiro_demo.dao;


import com.ddu.shiro_demo.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    static List<User> db;

    static {
        db = new ArrayList<>();
        db.add(new User("u001", "user01", "123456"));
        db.add(new User("u002", "user02", "123456"));
        db.add(new User("u003", "user03", "123456"));
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    public List<User> getUsers() {
        return db;
    }

    /**
     * 单条查询
     *
     * @param id 用户id
     * @return
     */
    public User getOne(String id) {
        for (User user : db) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

}
