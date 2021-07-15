package com.glii.ddbackmanage.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 失败
     */
    FAILURE(500,"操作失败")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
