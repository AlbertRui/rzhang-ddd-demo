package org.rzhang.study.ddd.bootstrap.spring.aspect;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.rzhang.study.ddd.common.consts.NumberConsts;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description: web log aspect
 *
 * @author: rzhang
 * @date: 2024-07-20 10:58:14
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {

    /**
     * 定义日志切面
     *
     * @param joinPoint 切入点
     * @return {@link Object}
     * @throws Throwable e
     */
    @Around("webLogPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        String fullQualifiedName = signature.getDeclaringTypeName() + StrUtil.DOT + signature.getName();

        String requestArgs = StrUtil.subPre(Arrays.toString(joinPoint.getArgs()), NumberConsts.MAX_LOG_MSG_LEN);
        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();

            long timeSpent = System.currentTimeMillis() - startTime;
            String returnRes = StrUtil.subPre(String.valueOf(result), NumberConsts.MAX_LOG_MSG_LEN);
            log.info("请求方法:{}, 请求参数:{}, 返回结果:{}, 执行耗时:{}ms", fullQualifiedName, requestArgs, returnRes, timeSpent);

            return result;
        } catch (Throwable e) {
            log.error("请求方法:{}, 请求参数:{}, 执行耗时:{}ms", fullQualifiedName, requestArgs, System.currentTimeMillis() - startTime, e);
            throw e;
        }
    }

    /**
     * 切入点范围为项目根目录
     */
    @Pointcut(value = "within(org.rzhang.study.ddd..*)")
    private void webLogPointCut() {}

}
