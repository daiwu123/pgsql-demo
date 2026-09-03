package com.example.pgsqldemo.regist.a;

import org.springframework.kafka.annotation.RetryableTopic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@RetryableTopic(attempts = "3")
public @interface MyRetry {
}
