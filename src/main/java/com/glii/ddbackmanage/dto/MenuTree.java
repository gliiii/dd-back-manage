package com.glii.ddbackmanage.dto;

import com.glii.ddbackmanage.entity.Menu;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
@Data
@ToString
public class MenuTree<T> implements Serializable {

    private static final long serialVersionUID = -9040695900935872532L;

    private String id;
    private String icon;
    private String href;
    private String title;
    private Map<String, Object> state;
    private boolean checked = false;
    private Map<String, Object> attributes;
    private List<MenuTree<T>> childs = new ArrayList<>();
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private Menu data;

}