package com.glii.ddbackmanage.vo;

import lombok.Data;

@Data
public class DeptVO {
    private Long deptId;
    private Long parentId;
    private String deptName;
    private Long orderNunm;
}
