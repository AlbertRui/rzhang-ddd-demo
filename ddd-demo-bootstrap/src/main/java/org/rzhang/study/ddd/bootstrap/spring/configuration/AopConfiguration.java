package org.rzhang.study.ddd.bootstrap.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description: aop configuration
 *
 * @author: rzhang
 * @date: 2024-07-19 23:22:10
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class AopConfiguration {
}
