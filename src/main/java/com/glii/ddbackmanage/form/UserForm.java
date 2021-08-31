package com.glii.ddbackmanage.form;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserForm {
    @JsonProperty("id")
    @JsonAlias("userId")
    private Long userId;

    private String username;

    private Long deptId;

    private String ssex;

    private String status;

    private String email;

    private String mobile;

    private String description;

    private String createTimeFrom;

    private String createTimeTo;

    private String roleId;
    private String roleName;
}
