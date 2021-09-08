package com.glii.ddbackmanage.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DeptVO {
    private Long deptId;
    private Long parentId;
    private String deptName;
    private Long orderNunm;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
