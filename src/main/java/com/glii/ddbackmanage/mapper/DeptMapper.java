package com.glii.ddbackmanage.mapper;

import com.glii.ddbackmanage.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DeptMapper {
    /**
     * 根据部门id查询部门信息列表
     * @param depIds
     * @return
     */
    List<Dept> findDeptsByDeptIdIn(List<Long> depIds);

    /**
     * 查询所有部门信息
     * @return
     */
    List<Dept> findDeptList();
}
