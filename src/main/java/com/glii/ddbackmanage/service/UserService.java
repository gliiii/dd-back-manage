package com.glii.ddbackmanage.service;

import com.glii.ddbackmanage.form.UserForm;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.vo.UserVO;

import java.util.List;

public interface UserService {
    /**
     * 查询用户信息列表
     * @param userForm
     * @param query
     * @return
     */
    List<UserVO> findUserDetailList(UserForm userForm, QueryRequst query);

    /**
     * 查询用户总数
     * @return
     */
    int findUsersCount();

    /**
     * 更新用户状态
     * @param userId
     * @param status
     * @return
     */
    Integer updateUserStatus(Integer userId, String status);

    /**
     * 新增用户
     * @param userForm
     * @return
     */
    Integer addUser(UserForm userForm);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    UserVO findUserById(Long userId);

    /**
     * 更新用户
     * @param userForm
     * @return
     */
    Integer updateUser(UserForm userForm);
}
