package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.dto.DeptTree;
import com.glii.ddbackmanage.entity.Dept;
import com.glii.ddbackmanage.mapper.DeptMapper;
import com.glii.ddbackmanage.service.DeptService;
import com.glii.ddbackmanage.vo.DeptVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class DeptServiceImplTest extends DdBackManageApplicationTests {

    @Autowired
    DeptService deptService;

    @Test
    void findDeptList() {
        List<DeptVO> deptList = deptService.findDeptList();
        System.out.println(deptList);
    }


    @Test
    void findDeptTree() {
        List<DeptTree<Dept>> deptTree = deptService.findDeptTree();
        System.out.println(deptTree);
    }
}