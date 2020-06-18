package com.zpy.township;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zpy.township.mapper")
@SpringBootApplication
public class TownshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(TownshipApplication.class, args);
    }

}
