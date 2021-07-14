package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.entity.User;
import com.glii.ddbackmanage.form.UserForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询用户列表
     * @return
     */
    List<User> findUserList(@Param("user") UserForm user, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize );

    /**
     * 查询用户总数
     * @return
     */
    Integer findUsersCount();

    /**
     * 根据用户id更新用户状态
     * @param userId
     * @return
     */
    Integer updateUserStatusById(@Param("userId") Integer userId, @Param("status") String status);
}
