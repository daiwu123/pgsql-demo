package com.example.pgsqldemo.regist;

import com.example.pgsqldemo.regist.a.Demo;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.kafka.annotation.RetryableTopic;

public class MergedAnnotationsTest {

    public static void main(String[] args) {
        MergedAnnotation<RetryableTopic> retryableTopicMergedAnnotation = MergedAnnotations.from(Demo.class).get(RetryableTopic.class);
        RetryableTopic ann = retryableTopicMergedAnnotation.synthesize(MergedAnnotation::isPresent)
                .orElse(null);
        System.out.println(ann.attempts());
    }
}
