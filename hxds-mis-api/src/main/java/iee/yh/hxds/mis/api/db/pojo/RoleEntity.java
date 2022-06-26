package iee.yh.hxds.mis.api.db.pojo;

import java.io.Serializable;

/**
 * 角色表
 * @TableName tb_role
 */
public class RoleEntity implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDefaultPermissions() {
        return defaultPermissions;
    }

    public void setDefaultPermissions(String defaultPermissions) {
        this.defaultPermissions = defaultPermissions;
    }

    public Integer getSystemic() {
        return systemic;
    }

    public void setSystemic(Integer systemic) {
        this.systemic = systemic;
    }

    /**
     * 主键
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 权限集合
     */
    private String permissions;

    /**
     * 描述
     */
    private String desc;

    /**
     * 系统角色内置权限
     */
    private String defaultPermissions;

    /**
     * 是否为系统内置角色
     */
    private Integer systemic;

    private static final long serialVersionUID = 1L;
}