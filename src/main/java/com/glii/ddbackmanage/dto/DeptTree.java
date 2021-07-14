package com.glii.ddbackmanage.dto;

import com.glii.ddbackmanage.entity.Dept;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DeptTree<T>  {

    private String id;
    private String icon;
    private String href;
    private String name;
    private Map<String, Object> state;
    private boolean checked = false;
    private Map<String, Object> attributes;
    private List<DeptTree<T>> children;
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private Dept data;

    public void initChildren() {
        children = new ArrayList<>();
    }

}
