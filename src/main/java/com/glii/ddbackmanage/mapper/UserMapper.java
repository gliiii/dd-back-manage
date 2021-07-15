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

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    User findUserById(Long userId);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Integer updateUser(@Param("user") User user);

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    Integer deleteUserById(Long userId);

    /**
     * 批量删除用户
     * @param userIds
     * @return
     */
    Integer deleteUserByIds(Long[] userIds);
}
