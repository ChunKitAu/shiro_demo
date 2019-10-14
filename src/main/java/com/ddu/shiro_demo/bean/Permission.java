package com.ddu.shiro_demo.bean;

/**
 * 权限
 */
public class Permission {
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String Name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Permission(String id, String name) {
        this.id = id;
        Name = name;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
