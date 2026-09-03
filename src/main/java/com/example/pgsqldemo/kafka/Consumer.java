package com.example.pgsqldemo.kafka;

import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
//@EnableKafkaRetryTopic
public class Consumer {

    //@RetryableTopic
    @KafkaListener(topics = "consumer-conf",groupId = "abc",concurrency = "2",autoStartup = "false")
    public void curConsumer(String msg){

    }
}
