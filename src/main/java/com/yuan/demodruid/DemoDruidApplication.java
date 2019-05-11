package com.yuan.demodruid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuan.demodruid.mapper")
public class DemoDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDruidApplication.class, args);
    }

}
