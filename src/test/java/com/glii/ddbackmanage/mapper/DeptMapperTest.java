package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.DdBackManageApplicationTests;
import com.glii.ddbackmanage.entity.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

class DeptMapperTest extends DdBackManageApplicationTests {

    @Autowired
    DeptMapper deptMapper;

    @Test
    void findDeptsByDeptIdIn() {
        List<Dept> deptList = deptMapper.findDeptsByDeptIdIn(Arrays.asList(1L,2L,3L));
        System.out.println(deptList);
    }

    @Test
    void findDeptList() {
        List<Dept> deptList = deptMapper.findDeptList();
        System.out.println(deptList);
    }
}