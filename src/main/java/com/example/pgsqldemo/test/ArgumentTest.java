package com.example.pgsqldemo.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.StopWatch;

import java.util.List;

@Slf4j
public class ArgumentTest {

    public static void main(String[] args) {
        watch();
    }


    public static void watch(){
        StopWatch sw = new StopWatch();

        sw.start("db");
        queryDb();
        sw.stop();

        sw.start("rpc");
        callRemote();
        sw.stop();

        log.info("\n{}", sw.prettyPrint());
    }

    public static void queryDb(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void callRemote(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void argumentTest(String[] args) {
        MyStudent myStudent = new MyStudent();
        myStudent.setName("默认");
        SpringFactoriesLoader.ArgumentResolver argumentResolver = SpringFactoriesLoader.ArgumentResolver.of(MyStudent.class, myStudent);
        argumentResolver = argumentResolver.and(String[].class, args);
        List<MyTeacherRun> load = SpringFactoriesLoader.forDefaultResourceLocation(ClassLoader.getSystemClassLoader()).load(MyTeacherRun.class, argumentResolver);
        for (MyTeacherRun myTeacherRun : load) {
            myTeacherRun.printRun();
        }
    }





    @Data
    public static class MyStudent{

        public String name;

    }




    public static class TeacherKu1 implements MyTeacherRun{

        public TeacherKu1(MyStudent myStudent, String [] args){
            System.out.println("TeacherKu1(MyStudent myStudent,String [] args)");
        }


        @Override
        public void printRun() {
            System.out.println(this.getClass().getName());
        }
    }
}
