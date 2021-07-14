package com.glii.ddbackmanage.vo;

import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private long count;
    private T data;
}
