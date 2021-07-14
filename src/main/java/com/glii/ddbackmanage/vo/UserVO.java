package com.glii.ddbackmanage.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class UserVO {
    @JsonProperty("id")
    private Long userId;
    private String username;
    @JsonProperty("sex")
    private String ssex;
    private String deptName;
    private String mobile;
    private String email;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
