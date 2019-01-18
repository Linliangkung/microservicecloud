package com.jsako.springcloud.dept;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import rx.Observable;
import rx.Subscriber;
import rx.internal.producers.SingleProducer;
import rx.internal.schedulers.NewThreadScheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Date 2019/1/9
 * @Author LLJ
 * @Description
 */
public class TestRxJava {

    @HystrixCommand
    public static void main(String[] args) {
    /*    Observable<String> observable = Observable.create(subscriber -> {
            System.out.println("Thread:" + Thread.currentThread().getName());

            subscriber.onNext("123");
            subscriber.onCompleted();
        });

        observable.doOnSubscribe(() -> {
            System.out.println("doOnSubscribe:" + Thread.currentThread().getName());
        })
                .subscribeOn(new NewThreadScheduler(new ThreadFactoryBuilder().build()))
                .observeOn(new NewThreadScheduler(new ThreadFactoryBuilder().build()))
                .doOnCompleted(() -> System.out.println("doOnCompleted:" + Thread.currentThread().getName()))
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted:" + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError:" + Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext:" + s + "," + Thread.currentThread().getName());
                    }
                });*/

       /* Observable<String> observable=Observable.defer(()->{
            System.out.println("defer create observabl:"+Thread.currentThread().getName());
            return  Observable.create((s)->s.setProducer(new SingleProducer(s,"213")));
        });
        observable.observeOn(new NewThreadScheduler(new ThreadFactoryBuilder().build())).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted:" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + Thread.currentThread().getName());
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:" + s + "," + Thread.currentThread().getName());
            }
        });*/


      /*  Observable<String> observable = Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            System.out.println("Thread:" + Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            subscriber.onNext("onNext value");
            subscriber.onCompleted();
        }).lift((s1) -> {
            Subscriber<String> ss = new Subscriber<String>() {
                @Override
                public void onCompleted() {
                    s1.onCompleted();
                }

                @Override
                public void onError(Throwable e) {
                    s1.onError(e);
                }

                @Override
                public void onNext(String s) {
                    s1.onNext(s);
                }
            };
            //测试
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Timer run");
                    s1.onError(new RuntimeException("test"));
                }
            }, 2000);
            return ss;
        });

        try {
            Future<String> stringFuture = observable*//*.subscribeOn(new NewThreadScheduler(new ThreadFactoryBuilder().build()))*//*.toBlocking().toFuture();
            String s = stringFuture.get();

            System.out.println(s);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
*/

        /*try {
            Observable.defer(() -> {
                throw new RuntimeException("123");
            }).doOnError(e -> {
                System.out.println(e.getMessage());
                throw new RuntimeException("321");
            }).doOnError(e -> {
                System.out.println(e.getMessage());
//                return null;
            }).subscribe();
        }catch (Exception e){
            System.out.println("error");
        }*/

        Observable<String> observable = Observable.create((Observable.OnSubscribe<String>)  subscriber -> subscriber.onError(new RuntimeException("123")));

        observable.onErrorResumeNext(Observable.create(subscriber -> subscriber.onError(new RuntimeException("321")))).subscribe(System.out::println,System.out::println);
    }

}
