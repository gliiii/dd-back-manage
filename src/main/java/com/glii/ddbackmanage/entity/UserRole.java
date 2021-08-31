package com.glii.ddbackmanage.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MrBird
 */
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = 2354394771912648574L;
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


}
