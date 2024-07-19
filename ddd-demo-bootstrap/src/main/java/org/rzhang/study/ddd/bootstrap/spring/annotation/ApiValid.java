package org.rzhang.study.ddd.bootstrap.spring.annotation;

import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

/**
 * @description: api valid
 * @author: rzhang
 * @date: 2024-07-19 23:11:37
 */
@Validated
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiValid {
}
