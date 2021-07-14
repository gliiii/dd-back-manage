package com.glii.ddbackmanage.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long userId;
    private String username;
    private String password;
    private Long deptId;
    private String email;
    private String mobile;
    private String status;
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Date modifyTime;
    private Date lastLoginTime;
    private String ssex;
    private String avatar;
    private String theme;
    private String isTab;
    private String description;
}
