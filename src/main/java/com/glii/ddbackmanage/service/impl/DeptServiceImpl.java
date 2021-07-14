package com.glii.ddbackmanage.service.impl;

import com.glii.ddbackmanage.dto.DeptTree;
import com.glii.ddbackmanage.entity.Dept;
import com.glii.ddbackmanage.mapper.DeptMapper;
import com.glii.ddbackmanage.service.DeptService;
import com.glii.ddbackmanage.utils.TreeUtil;
import com.glii.ddbackmanage.vo.DeptVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<DeptVO> findDeptList() {
        List<Dept> deptList = deptMapper.findDeptList();
        if (deptList == null) {
            //TODO 泛型返回
            return null;
        }
        List<DeptVO> deptVOList = deptList.stream().map(dept -> {
            DeptVO deptVO = new DeptVO();
            BeanUtils.copyProperties(dept, deptVO);
            return deptVO;
        }).collect(Collectors.toList());
//        List<DeptVO> deptVOList = new ArrayList<>();
//        for (Dept dept : deptList) {
//            DeptVO deptVO = new DeptVO();
//            BeanUtils.copyProperties(dept,deptVO);
//            deptVOList.add(deptVO);
//        }
        return deptVOList;
    }

    @Override
    public List<DeptTree<Dept>> findDeptTree() {
        List<Dept> deptList = deptMapper.findDeptList();
        List<DeptTree<Dept>> trees = convertDept(deptList);
        return TreeUtil.buildDeptTree(trees);
    }

    private List<DeptTree<Dept>> convertDept(List<Dept> deptList) {
        List<DeptTree<Dept>> trees = new ArrayList<>();
        deptList.forEach(dept -> {
            DeptTree<Dept> tree = new DeptTree<>();
            tree.setId(String.valueOf(dept.getDeptId()));
            tree.setParentId(String.valueOf(dept.getParentId()));
            tree.setName(dept.getDeptName());
            tree.setData(dept);
            trees.add(tree);
        });
        return trees;
    }
}
