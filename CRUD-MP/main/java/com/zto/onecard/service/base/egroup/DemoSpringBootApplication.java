package com.zto.onecard.service.base.egroup;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 *
 * @author
 * @date
 */
@MapperScan("com.zto.onecard.service.base.egroup")
@SpringBootApplication
//@EnableSwagger2
@Slf4j
public class DemoSpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoSpringBootApplication.class, args);
        System.out.println("===========================>>>>>>启动成功");
        log.info("=============================>>>启动成功");
    }



}

