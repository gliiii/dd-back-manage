package com.glii.ddbackmanage.form;

import lombok.Data;

@Data
public class UserForm {
    private String username;

    private Long deptId;

    private String ssex;

    private String status;

    private String mobile;

    private String createTimeFrom;

    private String createTimeTo;
}
