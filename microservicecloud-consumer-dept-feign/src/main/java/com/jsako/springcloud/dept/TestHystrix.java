package com.jsako.springcloud.dept;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Date 2019/1/10
 * @Author LLJ
 * @Description
 */
public class TestHystrix {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*for(int i=0;i<10000;i++){

            HystrixCommand<String> test = new HystrixCommand<String>(HystrixCommandGroupKey.Factory.asKey("test"),100000) {

                @Override
                protected String run() throws Exception {
                    Thread.sleep(5000);
                    int i = 1 / 0;
                    return "123";
                }

                @Override
                protected String getFallback() {
                    return "321";
                }
            };

            Future<String> queue = test.queue();
            if(i%2==0) {
                System.out.println(queue.get());
            }
        }*/
       // for(int i=0;i<3;i++) {
            /*new Thread(){
                @Override
                public void run() {*/
                    HystrixCommand<String> command = new HystrixCommand<String>(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey
                            .Factory.asKey("test"))
                            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                    .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                                    .withExecutionTimeoutEnabled(true).withExecutionTimeoutInMilliseconds(1000)
                                    .withExecutionIsolationSemaphoreMaxConcurrentRequests(2))) {
                        @Override
                        protected String run() throws Exception {
                            Thread.sleep(5000);
                            return "123";
                        }

                        @Override
                        protected String getFallback() {
                            return "error";
                        }
                    };
                    System.out.println(command.execute());
         /*       }
            }.start();*/

       // }
    }
}
