package org.rzhang.study.ddd.bootstrap;

import org.rzhang.study.ddd.common.consts.StringConsts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 *
 * @author: rzhang
 * @date: 2024-07-18
 */
@SpringBootApplication(scanBasePackages = {StringConsts.PROJECT_BASE_PACKAGE})
public class DddDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddDemoApplication.class, args);
    }

}
