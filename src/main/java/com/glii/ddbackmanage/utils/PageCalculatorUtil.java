package com.glii.ddbackmanage.utils;

public class PageCalculatorUtil {

    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;

    }
}
