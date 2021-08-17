package com.glii.ddbackmanage.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class RoleVO {
    /**
     * 角色ID
     */
    @JsonProperty("id")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
