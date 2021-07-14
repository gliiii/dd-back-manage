package com.glii.ddbackmanage.controller.system;

import com.glii.ddbackmanage.form.UserForm;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.UserService;
import com.glii.ddbackmanage.utils.ResultVOUtil;
import com.glii.ddbackmanage.vo.ResultVO;
import com.glii.ddbackmanage.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/sys/users")
    public ResultVO userList(UserForm user, QueryRequst query) {
        List<UserVO> userVOList = userService.findUserDetailList(user, query);
        int count = userService.findUsersCount();
        return ResultVOUtil.success(userVOList,count);
    }

    @PutMapping("/user/{id}")
    public ResultVO updateUserStatus(@PathVariable("id") Integer userId, Boolean status) {
        String statusStr = null;
        userService.updateUserStatus(userId, statusStr=status?"1":"0");
        return ResultVOUtil.success();
    }
}
