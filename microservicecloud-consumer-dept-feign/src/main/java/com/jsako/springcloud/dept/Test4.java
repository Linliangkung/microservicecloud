package com.jsako.springcloud.dept;

/**
 * @Date 2019/1/28
 * @Author LLJ
 * @Description
 */
public class Test4 {
    public static int i=0;
    public static boolean flag=false;
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            Thread thread1 = new Thread(() -> {
                i = 1;
                flag = true;
            });


            Thread thread2 = new Thread(() -> {
                if (flag) {
                   // System.out.println(i);
                    if (i == 0) {
                        System.out.println("i===0");
                    }
                }
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            i=0;
            flag=false;
        }

    }



}
