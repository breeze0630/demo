package com.example.other.trans.config;


import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

/**
 * @author Joker
 * @version 1.0.0
 * @description 切Controller打印日志
 * @since 2022/6/17
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 以自定义 @WebLog 注解为切点
     */
    @Pointcut("execution(* com.example.*.*.controller..*(..))")
    public void printLog() {
    }

    /**
     * @param proceedingJoinPoint 连接点
     */
    @Around("printLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        final List<String> params = new ArrayList<>();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(attributes)) {
            return proceedingJoinPoint.proceed();
        }
        HttpServletRequest request = attributes.getRequest();
        if (request.getMethod().equals("GET")) {
            params.add(JSONObject.toJSONString(copyToStringValueMap(request.getParameterMap())));
        } else {
            Object[] args = proceedingJoinPoint.getArgs();
            for (Object object : args) {
                if (!(object instanceof HttpServletResponse) && !(object instanceof HttpServletRequest)) {
                    params.add(object.toString());
                }
            }
        }
        long startTime = System.currentTimeMillis();
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String method = proceedingJoinPoint.getSignature().getName();
        String traceId = IdUtil.fastSimpleUUID();
        if (params.size() > 0) {
            String arguments = params.get(0).replaceAll("\\\\|\\r\\n|\\r|\\n|\\n\\r|\\s*", "");
            log.info("{}.{}-{}-arguments:{}", className, method, traceId, arguments);
        }
        result = proceedingJoinPoint.proceed();
        String returnedMessages = Objects.isNull(result) ? "{}" : JSONObject.toJSONString(result);
        log.info("{}.{}-耗时{}-{}-returnedMessages:{}", className, method, System.currentTimeMillis() - startTime,
                 traceId, returnedMessages);
        return result;
    }

    @After("printLog()")
    public void doAfter() {
        log.info(LINE_SEPARATOR);
    }

    /**
     * Map<String,String[]> to Map<String,String>
     *
     * @param input Map<String,String[]>
     * @return Map<String, String>
     */
    public static Map<String, String> copyToStringValueMap(Map<String, String[]> input) {
        if (MapUtil.isEmpty(input)) {
            return new HashMap<>();
        }
        Map<String, String> ret = new HashMap<>();
        for (Map.Entry<String, String[]> entry : input.entrySet()) {
            ret.put(entry.getKey(), entry.getValue()[0]);
        }
        return ret;
    }
}
