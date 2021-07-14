package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.entity.Dept;
import com.glii.ddbackmanage.entity.User;
import com.glii.ddbackmanage.form.UserForm;
import com.glii.ddbackmanage.mapper.DeptMapper;
import com.glii.ddbackmanage.mapper.UserMapper;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.UserService;
import com.glii.ddbackmanage.utils.PageCalculatorUtil;
import com.glii.ddbackmanage.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<UserVO> findUserDetailList(UserForm user, QueryRequst query) {
        int pageIndex = query.getPage();
        int pageSize = query.getLimit();
        //查询用户列表
        List<User> userList = userMapper.findUserList(user,PageCalculatorUtil.calculateRowIndex(pageIndex,pageSize),pageSize);
        if (userList.size()==0) {
            //TODO 此处需要优化，采用泛型返回
            return null;
        }
        //获取用户部门列表id
        List<Long> deptIds = userList.stream().map(User::getDeptId).collect(Collectors.toList());
        //查询部门详情
        List<Dept> deptList = deptMapper.findDeptsByDeptIdIn(deptIds);
        List<UserVO> userVOList = new ArrayList<>();
        for (User userTemp : userList) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userTemp, userVO);
            for (Dept dept : deptList) {
                if (userTemp.getDeptId().equals(dept.getDeptId())) {
                    userVO.setDeptName(dept.getDeptName());
                }
            }
            userVOList.add(userVO);
        }
        return userVOList;
    }

    @Override
    public int findUsersCount() {
        return userMapper.findUsersCount();
    }

    @Override
    public Integer updateUserStatus(Integer userId, String status) {
        //TODO 考虑更新失败返回？
        return userMapper.updateUserStatusById(userId, status);
    }
}
