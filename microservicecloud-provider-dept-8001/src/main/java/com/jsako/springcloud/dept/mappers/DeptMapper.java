package com.jsako.springcloud.dept.mappers;

import com.jsako.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
@Mapper
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
