package com.vonchange.nine.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vonchange.spring.data.mybatis.mini.jdbc.repository.config.EnableMybatisMini;

//@SpringBootApplication(exclude={JdbcConfiguration.class})
@SpringBootApplication
//@ComponentScan(basePackages={"com.vonchange"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableMybatisMini
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}
