package com.xdcplus.xdcweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Spring 启动后自定义加载类
 * @date 2021/04/29 08:58
 * @author Rong.Jia
 */
@Slf4j
@Component
public class XdcWebApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {

        log.info("XdcWebApplicationRunner start ... ");





    }
}
