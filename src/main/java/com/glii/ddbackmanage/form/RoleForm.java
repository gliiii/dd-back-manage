package com.glii.ddbackmanage.form;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.Date;

@Data
public class RoleForm {
    /**
     * 角色ID
     */
    @JsonAlias("id")
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 角色对应的菜单（按钮） id
     */
    private transient String menuIds;
}
