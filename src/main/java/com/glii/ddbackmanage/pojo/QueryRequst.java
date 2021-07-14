package com.glii.ddbackmanage.pojo;

import lombok.Data;

@Data
public class QueryRequst {
    /**
     * 当前页面数据量
     */
    private int page = 10;

    /**
     * 当前页码
     */
    private int limit = 1;

    /**
     * 排序字段
     */
    private String field;

    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;
}
