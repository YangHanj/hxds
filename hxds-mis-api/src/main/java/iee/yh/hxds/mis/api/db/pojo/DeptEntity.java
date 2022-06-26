package iee.yh.hxds.mis.api.db.pojo;

import java.io.Serializable;

/**
 * 部门表
 * @TableName tb_dept
 */
public class DeptEntity implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门电话
     */
    private String tel;

    /**
     * 部门邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String desc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}