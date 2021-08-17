package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.entity.Role;
import com.glii.ddbackmanage.form.RoleForm;
import com.glii.ddbackmanage.mapper.RoleMapper;
import com.glii.ddbackmanage.pojo.QueryRequst;
import com.glii.ddbackmanage.service.RoleService;
import com.glii.ddbackmanage.utils.PageCalculatorUtil;
import com.glii.ddbackmanage.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

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
}
