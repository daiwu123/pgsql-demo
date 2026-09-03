package com.example.pgsqldemo.regist;

import java.io.Serializable;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    
    public static void main(String[] args) throws InterruptedException {


        AtomicInteger i = new AtomicInteger(0);
        /*Method method = null;
        Class<?> clazz = null;
        GenericDeclaration genericDeclaration = Objects.requireNonNullElse(method, clazz);*/
        String a = "中";
        for (byte aByte : a.getBytes(StandardCharsets.UTF_16)) {
            System.out.println(aByte);
        }
        byte [] av= {-2,-1,78,45};
        String s1 = new String(av, StandardCharsets.UTF_8);
        System.out.println(s1);
        String s = "😀";
        System.out.println(s.length());

        String  ss= "中A😀";
        System.out.println(Arrays.toString(ss.getBytes()));
        //byte [] b = {228,184,173,65,240,159,152,128};

        Semaphore semaphore = new Semaphore(2);

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("t1获取锁开始运行");
                Thread.sleep(3000);
                condition.await();
                System.out.println("t1开始执行");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("t1释放锁");
                lock.unlock();
            }
        });


        Thread t2 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("t2开始运行,进行通知");
                condition.signalAll();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }  finally {
                System.out.println("t2释放锁");
                lock.unlock();
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
        System.out.println("运行结束");
    }
}
