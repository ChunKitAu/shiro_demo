package com.ddu.shiro_demo.bean;

/**
 * 中间表 user对应的角色
 */
public class URole {
    /**
     * id
     */
    private Integer id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 用户id
     */
    private String userId;

    public URole(Integer id, String roleId, String userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "URole{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
