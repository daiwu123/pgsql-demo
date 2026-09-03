package com.example.pgsqldemo.regist;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.core.Ordered;

public class MyRegister implements BeanPostProcessor, Ordered, ApplicationContextAware, SmartInitializingSingleton , SmartLifecycle {

    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessBeforeInitialization ...");
        return bean;
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessAfterInitialization ...");
        return bean;
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("afterSingletonsInstantiated ...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext ...");
    }

    @Override
    public int getOrder() {
        System.out.println("getOrder");
        return 0;
    }

    private volatile boolean running = false;


    @Override
    public void start() {
        running = true;
        System.out.println("start被调用了");
        //throw  new RuntimeException("出现异常了");
    }

    @Override
    public void stop() {
        System.out.println("stop被调用了");
    }

    @Override
    public boolean isRunning() {
        System.out.println("isRunning");
        return running;
    }

    @Override
    public boolean isAutoStartup() {
        System.out.println("isAutoStartup");
        return true;
    }

    @Override
    public boolean isPauseable() {
        System.out.println("isPauseable");
        return SmartLifecycle.super.isPauseable();
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("stop(Runnable callback)");
        SmartLifecycle.super.stop(callback);
    }

    @Override
    public int getPhase() {
        System.out.println("getPhase");
        return 0;
    }
}
