package com.jsako.springcloud.dept;

import org.eclipse.jetty.util.BlockingArrayQueue;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2019/1/21
 * @Author LLJ
 * @Description
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
       /* CountDownLatch count=new CountDownLatch(1);

        new Thread(){
            @Override
            public void run() {
                try {
                    count.await();
                    System.out.println("thread1 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    count.await();
                    System.out.println("thread2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        count.countDown();*/

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 30, TimeUnit.SECONDS, new BlockingArrayQueue<>(4));
        threadPoolExecutor.execute(()->{
            System.out.println("run1:  1111"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadPoolExecutor.execute(()->{
            System.out.println("run1:"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadPoolExecutor.execute(()->{
            System.out.println("run1:"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadPoolExecutor.execute(()->{
            System.out.println("run1:"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadPoolExecutor.execute(()->{
            System.out.println("run1:"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPoolExecutor.execute(()->{
            System.out.println("run1: 66666"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPoolExecutor.execute(()->{
            System.out.println("run1 77777:"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(60000);



        threadPoolExecutor.execute(()->{
            System.out.println("run1 77777:"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadPoolExecutor.execute(()->{
            System.out.println("run1 77777:"+Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
