package com.jsako.springcloud.dept;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Date 2019/1/24
 * @Author LLJ
 * @Description
 */
public class Test3 {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
       /* while(true) {
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            other.start();
            one.join();
            other.join();
            if(x==0&&y==0)
            System.out.println("(" + x + "," + y + ")");

            a=0;
            b=0;
        }*/
//        URLClassLoader loader = new URLClassLoader(new URL[]{new URL("file://C://Users/Administrator/Desktop/test")}, Thread.currentThread().getContextClassLoader());
        ClassLoader loader=new MyClassLoader();
        Class<?> aClass = loader.loadClass("com.test.Father");
        System.out.println(aClass);
        Object o = aClass.newInstance();

    }

    public static class MyClassLoader extends ClassLoader{
        int i=0;
        @Override

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] buf=new byte[1024*10];
            int read =0;
            try {
                String path="";
                if(i==0){
                    i++;
                    path="C:\\Users\\Administrator\\Desktop\\test\\com\\test\\Father.class";
                }else{
                    path="C:\\Users\\Administrator\\Desktop\\test\\com\\test\\Son.class";

                }
                FileInputStream inputStream=new FileInputStream(path);
                 read=inputStream.read(buf);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(read);
            Class<?> aClass = defineClass(name, buf, 0, read);
            return aClass;
        }
    }
}
