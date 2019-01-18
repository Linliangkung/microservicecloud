package com.jsako.springcloud.dept.controller;

import com.jsako.springcloud.entities.Dept;
import com.jsako.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
@RestController
@RequestMapping("/api/dpet/consumer")
public class DeptConsumerController {
   // private final static String DEPT_SERVICE_PREFIX="http://MICROSERVICECLOUD-DEPT/";


   @Autowired
    private DeptClientService deptClientService;

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptClientService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Integer id){
        return deptClientService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    @GetMapping("/discovery")
    public Object discovery(){
        return deptClientService.discovery();
    }


}
