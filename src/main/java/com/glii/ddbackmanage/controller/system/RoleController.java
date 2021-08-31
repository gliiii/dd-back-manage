package com.glii.ddbackmanage.controller.system;

import com.glii.ddbackmanage.entity.Role;
import com.glii.ddbackmanage.form.RoleForm;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.RoleService;
import com.glii.ddbackmanage.utils.ResultVOUtil;
import com.glii.ddbackmanage.vo.ResultVO;
import com.glii.ddbackmanage.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role/select/tree")
    public ResultVO getAllRoles() {
        List<Role> roles = roleService.findRoles();
        return ResultVOUtil.success(roles);
    }

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

    @PutMapping("/role")
    public ResultVO updateRole(@RequestBody RoleForm roleForm) {
        roleService.updateRole(roleForm);
        return ResultVOUtil.success();
    }

    @DeleteMapping("/roles/{ids}")
    public ResultVO batchDeleteRole(@PathVariable("ids") List<Long> roleIds) {
        roleService.deleteRoleByIds(roleIds);
        return ResultVOUtil.success();
    }
}
