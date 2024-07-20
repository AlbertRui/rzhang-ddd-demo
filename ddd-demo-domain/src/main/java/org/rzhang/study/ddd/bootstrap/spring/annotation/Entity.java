package org.rzhang.study.ddd.bootstrap.spring.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @description: 实体
 *
 * @author: rzhang
 * @date: 2024-07-20 12:18:02
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Entity {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
