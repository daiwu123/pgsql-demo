package com.example.pgsqldemo.regist;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.ClassUtils;

public class SystemConfig {


    @Bean
    public User user(){
        User user = new User();
        user.setName("zhangsan");

        boolean present = ClassUtils.isPresent("com.example.pgsqldemo.regist.MyImportSelector", null);
        boolean present1 = ClassUtils.isPresent("com.example.pgsqldemo.regist.SystemConfig$User", null);
        boolean present2 = ClassUtils.isPresent("com.example.pgsqldemo.regist.SystemConfig$User1", null);
        return user;
    }


    @Data
    public static class User{
        private String name;
    }
}
