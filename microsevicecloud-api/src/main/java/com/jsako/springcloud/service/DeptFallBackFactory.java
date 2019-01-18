package com.jsako.springcloud.service;

import com.jsako.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * @Date 2019/1/16
 * @Author LLJ
 * @Description
 */
public class DeptFallBackFactory implements FallbackFactory<DeptFallBackFactory.DeptClientServiceFallback> {
    @Override
    public DeptClientServiceFallback create(Throwable cause) {
        return new DeptClientServiceFallback(cause);
    }

    public static class DeptClientServiceFallback implements DeptClientService{

        private final Throwable cause;

        public DeptClientServiceFallback(Throwable cause) {
            this.cause = cause;
        }

        @Override
        public Dept get(long id) {
            System.out.println(cause.getMessage());
            return new Dept(0L,"出错啦" ,"error" );
        }

        @Override
        public List<Dept> list() {
            return null;
        }

        @Override
        public boolean add(Dept dept) {
            return false;
        }

        @Override
        public Object discovery() {
            return null;
        }
    }

}