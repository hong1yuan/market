package com.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描dao层 有@MapperScan(注解则不需要在mapper接口中写@Mapper注解（启动类中写@MapperScan和mapper接口中写@Mapper注解存在一个就行）
@MapperScan(basePackages= {"com.market.mapper"})
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }
}
