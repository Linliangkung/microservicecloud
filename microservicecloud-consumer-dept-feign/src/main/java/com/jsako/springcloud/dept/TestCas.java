package com.jsako.springcloud.dept;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Date 2019/1/17
 * @Author LLJ
 * @Description
 */
public class TestCas {


    public static void main(String[] args){
        AtomicBoolean b=new AtomicBoolean(false);
        new Thread(() -> {
            boolean andSet = b.compareAndSet(false,true);
            System.out.println(andSet);
        }).start();

        new Thread(() ->{
            boolean andSet = b.compareAndSet(false,true);
            System.out.println(andSet);
        } ).start();
    }

}
