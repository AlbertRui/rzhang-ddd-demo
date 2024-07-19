package org.rzhang.study.ddd.common.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @description: jackson util
 *
 * @author: rzhang
 * @date: 2024-07-19 23:47:45
 */
@Slf4j
public final class JacksonUtil {

    private static volatile ObjectMapper OBJECT_MAPPER;

    /**
     * 获取ObjectMapper
     *
     * @return objectMapper instance
     */
    public static ObjectMapper getObjectMapper() {
        if (Objects.isNull(OBJECT_MAPPER)) {
            synchronized (ObjectMapper.class) {
                if (Objects.isNull(OBJECT_MAPPER)) {
                    OBJECT_MAPPER = SpringUtil.getBean(ObjectMapper.class);
                }
            }
        }

        return OBJECT_MAPPER;
    }

    /**
     * 序列化Java对象为JSON字符串
     *
     * @param obj Java对象
     * @return 序列化后的字符串
     */
    public static String toJsonString(Object obj) {
        if (Objects.isNull(obj)) {
            return null;
        }

        try {
            return getObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("toJsonString error, object is : {}", obj, e);

            return null;
        }
    }

    /**
     * 反序列化json字符串为Java对象
     *
     * @param jsonString json string
     * @param clazz Java对象类型
     * @return {@link T}
     */
    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        if (StrUtil.isBlank(jsonString) || null == clazz) {
            return null;
        }

        try {
            return getObjectMapper().readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            log.error("parse object error, json string is : {}", jsonString, e);

            return null;
        }
    }

    private JacksonUtil() {}

}
