package com.glii.ddbackmanage.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Dept {
    private Long deptId;
    private Long parentId;
    private String deptName;
    private Long orderNum;
    private Date createTime;
    private Date modifyTime;
}
