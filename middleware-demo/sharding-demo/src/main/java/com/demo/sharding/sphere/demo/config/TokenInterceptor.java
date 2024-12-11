//package com.demo.sharding.sphere.demo.config;
//
//import cn.hutool.core.util.IdUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.annotation.PreDestroy;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @auther: liubiao
// * @date: 2024-12-09
// */
//
//@Component
//@Slf4j
//public class TokenInterceptor implements HandlerInterceptor {
//    private static final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//
//    public TokenInterceptor() {
//    }
//
//
//
//    @PreDestroy
//    public void destroyPool() {
//        executor.destroy();
//    }
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (StringUtils.isEmpty(SecurityContextHolder.getUserID())) {
//            SecurityContextHolder.setUserId(IdUtil.fastSimpleUUID());
//        }
//        log.info("TokenInterceptor.{}", SecurityContextHolder.getUserID());
//
//
//        return true;
//
//    }
//
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        SecurityContextHolder.remove();
//    }
//}
