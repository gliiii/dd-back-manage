package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.entity.Role;
import com.glii.ddbackmanage.entity.RoleMenu;
import com.glii.ddbackmanage.form.RoleForm;
import com.glii.ddbackmanage.mapper.RoleMapper;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.RoleMenuService;
import com.glii.ddbackmanage.service.RoleService;
import com.glii.ddbackmanage.utils.PageCalculatorUtil;
import com.glii.ddbackmanage.vo.RoleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public List<RoleVO> findRoleDetailList(RoleForm roleForm, QueryRequst query) {
        int pageIndex = query.getPage();
        int pageSize = query.getLimit();
        List<Role> roleList = roleMapper.findRoleList(roleForm, PageCalculatorUtil.calculateRowIndex(pageIndex, pageSize), pageSize);
        List<RoleVO> roleVOList = roleList.stream().map(role -> {
            RoleVO roleVO = new RoleVO();
            BeanUtils.copyProperties(role, roleVO);
            return roleVO;
        }).collect(Collectors.toList());
        return roleVOList;
    }

    @Override
    public int findRsCount() {
        return roleMapper.findRoleCount();
    }

    @Override
    public void addRole(RoleForm roleForm) {
        roleForm.setCreateTime(new Date());
        Role role = new Role();
        BeanUtils.copyProperties(roleForm, role);
        roleMapper.insertRole(role);
        saveRoleMenus(role);
    }

    @Override
    public RoleVO findRoleById(Long roleId) {
        Role role = roleMapper.findRoleById(roleId);
        RoleVO roleVO = new RoleVO();
        BeanUtils.copyProperties(role, roleVO);
        return roleVO;
    }

    @Override
    public void updateRole(RoleForm roleForm) {
        Role role = new Role();
        BeanUtils.copyProperties(roleForm, role);
        role.setModifyTime(new Date());
        roleMapper.updateRole(role);
        List<Long> roleIds = new ArrayList();
        roleIds.add(role.getRoleId());
        roleMenuService.deleteRoleMenuByRoleIds(roleIds);
        saveRoleMenus(role);
    }

    @Override
    public void deleteRoleByIds(List<Long> roleIds) {
        roleMapper.deleteRoleByIds(roleIds);
        roleMenuService.deleteRoleMenuByRoleIds(roleIds);
    }

    private void saveRoleMenus(Role role) {
        if (StringUtils.isNotBlank(role.getMenuIds())) {
            String[] menuIds = role.getMenuIds().split(",");
            List<RoleMenu> roleMenus = new ArrayList();
            Arrays.stream(menuIds).forEach(menuId -> {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(role.getRoleId());
                roleMenu.setMenuId(Long.valueOf(menuId));
                roleMenus.add(roleMenu);
            });
            roleMenuService.batchAddRoleMenu(roleMenus);
        }
    }
}
