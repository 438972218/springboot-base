package com.xdcplus.xdcweb;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 * @date 2021/04/29 08:58
 * @author Rong.Jia
 */
@EnableCaching
@EnableScheduling
@EnableAsync
@EnableSwagger2Doc
@EnableTransactionManagement
@MapperScan({"com.xdcplus.xdcweb.basics.mapper", "com.xdcplus.xdcweb.demo.mapper"})
@SpringBootApplication(scanBasePackages = {"com.xdcplus.*", "cn.hutool.extra.*"})
public class XdcWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdcWebApplication.class, args);
    }

}
