package com.example.pgsqldemo.controller;

import com.example.pgsqldemo.regist.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private SystemConfig.User user;

    @Autowired
    private Environment environment;

    @GetMapping("/test1")
    public String soReq(){

        return user.getName();
    }

    @GetMapping("/environment11")
    public String environment11(){
        String nacosurl = environment.getProperty("self.add");
        return nacosurl;
    }
}
