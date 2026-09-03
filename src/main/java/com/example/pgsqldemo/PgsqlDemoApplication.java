package com.example.pgsqldemo;

import com.example.pgsqldemo.regist.MyDeferredImportSelector;
import com.example.pgsqldemo.regist.MyImportSelector;
import com.example.pgsqldemo.regist.MyRegisterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.kafka.autoconfigure.KafkaAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.util.Map;
import java.util.Properties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({MyRegisterConfig.class,MyImportSelector.class, MyDeferredImportSelector.class})
public class PgsqlDemoApplication {

    public static void main(String[] args) {
        //SpringApplication.withHook();

        Properties properties = System.getProperties();
        Map<String, String> getenv = System.getenv();
        SpringApplication.run(PgsqlDemoApplication.class, args);
    }

}
