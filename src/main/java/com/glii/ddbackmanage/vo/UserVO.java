package com.glii.ddbackmanage.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Data
@ToString
public class UserVO implements Serializable {

    private static final long serialVersionUID = 2690867148500897890L;

    @JsonProperty("id")
    private Long userId;
    private String username;
    @JsonProperty("sex")
    private String ssex;
    private Long deptId;
    private String deptName;
    private String mobile;
    private String email;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private String description;
}
