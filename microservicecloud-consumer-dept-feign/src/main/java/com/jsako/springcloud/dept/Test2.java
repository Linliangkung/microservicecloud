package com.jsako.springcloud.dept;

import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Constructor;

/**
 * @Date 2019/1/22
 * @Author LLJ
 * @Description
 */
public class Test2 {

    private static volatile Data data;

    public static void setData(int a, int b) {
        data = new Data(a, b);
    }

    private static class Data {
        private int a;
        private int b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int[] getValues(){
            return new int[]{a,b};
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000000; i++) {
            int a = i;
            int b = i;
            //writer
            Thread writerThread = new Thread(() -> {
                setData(a, b);
            });
            //reader
            Thread readerThread = new Thread(() -> {
                while (data == null) {
                }
                int[] values = data.getValues();
                int x = values[0];
                int y = values[1];
                if (x != y) {
                    System.out.printf("a = %s, b = %s%n", x, y);
                }
            });

            writerThread.start();
            readerThread.start();
            writerThread.join();
            readerThread.join();
        }
        System.out.println("finished");


    }
}
