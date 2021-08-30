package com.glii.ddbackmanage.controller.system;

import com.glii.ddbackmanage.form.RoleForm;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.RoleService;
import com.glii.ddbackmanage.utils.ResultVOUtil;
import com.glii.ddbackmanage.vo.ResultVO;
import com.glii.ddbackmanage.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public ResultVO roleList(RoleForm roleForm, QueryRequst query) {
        List<RoleVO> roleDetailList = roleService.findRoleDetailList(roleForm, query);
        int count = roleService.findRsCount();
        return ResultVOUtil.success(roleDetailList,count);
    }

    @PostMapping("/role")
    public ResultVO addRole(RoleForm roleForm) {
        roleService.addRole(roleForm);
        return ResultVOUtil.success();
    }
}
