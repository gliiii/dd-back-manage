package com.glii.ddbackmanage.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Menu {

    /**
     * 菜单
     */
    public static final String TYPE_MENU = "0";
    /**
     * 按钮
     */
    public static final String TYPE_BUTTON = "1";
    public static final Long TOP_NODE = 0L;
    private static final long serialVersionUID = 8571011372410167901L;
    /**
     * 菜单/按钮ID
     */
    private Long menuId;

    /**
     * 上级菜单ID
     */
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    private String menuName;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    private String type;

    /**
     * 排序
     */
    private Long orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
}
