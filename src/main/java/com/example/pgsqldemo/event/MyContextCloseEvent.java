package com.example.pgsqldemo.event;

import org.springframework.boot.bootstrap.BootstrapContextClosedEvent;
import org.springframework.context.ApplicationListener;

public class MyContextCloseEvent implements ApplicationListener<BootstrapContextClosedEvent> {
    @Override
    public void onApplicationEvent(BootstrapContextClosedEvent event) {
        System.out.println("BootstrapContextClosedEvent.close");
    }
}
