package com.example.pgsqldemo.regist;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.core.Ordered;

public class MyWorker implements  SmartLifecycle {

    private volatile boolean running = false;


    @Override
    public void start() {
        running = true;
        System.out.println("MyWorker=start被调用了");
    }

    @Override
    public void stop() {
        System.out.println("MyWorker=stop被调用了");
    }

    @Override
    public boolean isRunning() {
        System.out.println("MyWorker=isRunning");
        return running;
    }

    @Override
    public boolean isAutoStartup() {
        System.out.println("MyWorker=isAutoStartup");
        return true;
    }

    @Override
    public boolean isPauseable() {
        System.out.println("MyWorker=isPauseable");
        return SmartLifecycle.super.isPauseable();
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("MyWorker=stop(Runnable callback)");
        SmartLifecycle.super.stop(callback);
    }

    @Override
    public int getPhase() {
        System.out.println("MyWorker=getPhase");
        return 1;
    }
}
