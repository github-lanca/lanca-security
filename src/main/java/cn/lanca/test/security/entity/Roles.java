package cn.lanca.test.security.entity;

import lombok.Data;


/**
 * @author hongliang.mei
 * @since 2020/11/18 17:38
 */
@Data
public class Roles {
    // id
    private String roleId;
    // name
    private String roleName;
    // desc
    private String roleDesc;

    public Roles() {
    }

    public Roles(String roleId, String roleName, String roleDesc) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
