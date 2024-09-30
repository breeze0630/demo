package com.example.mybatisplusexample.aspect;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.Objects;

/**
 * @Description 记录用户登录登出记录的切面
 * @author wangbing
 * @version 1.0
 * @since 2023/4/10 9:00
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 登录操作的切点
     */
    @Pointcut("execution(* com.example.mybatisplusexample.*.*(..))")
    public void writeLog() {
    }


    /**
     * 记录日志
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("writeLog()")
    public Object writeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Date now = new Date();
        Object result;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(attributes)) {
            return proceedingJoinPoint.proceed();
        }
        HttpServletRequest request = attributes.getRequest();


        Object[] args = proceedingJoinPoint.getArgs();
        for (Object object : args) {
            if (object instanceof Object) {
             log.info("param:{}", JSON.toJSONString(object));
            }
        }


        result = proceedingJoinPoint.proceed();
        if (result instanceof Object) {
            log.info("res:{}", JSON.toJSONString(result));
        }
        return result;
    }

}
