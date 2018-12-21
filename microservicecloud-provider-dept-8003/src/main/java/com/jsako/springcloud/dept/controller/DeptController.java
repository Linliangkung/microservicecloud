package com.jsako.springcloud.dept.controller;

import com.jsako.springcloud.dept.service.DeptService;
import com.jsako.springcloud.entities.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
@RestController
@RequestMapping("/api/dept")
public class DeptController {

    public final static Logger LOGGER= LoggerFactory.getLogger(DeptController.class.getName());

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept getDeptById(@PathVariable Long id){
        return deptService.findById(id);
    }

    @GetMapping("/list")
    public List<Dept> listDept(){
        LOGGER.info("8002 list");
        return deptService.findAll();
    }

}
