package com.demo.sharding.sphere.demo.config;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @auther: liubiao
 * @date: 2024-12-09
 */
@Slf4j
@Component
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (StringUtils.isEmpty(SecurityContextHolder.getUserID())) {
            SecurityContextHolder.set2(IdUtil.fastSimpleUUID());
        }
        log.info("TestFilter.{}.{}",Thread.currentThread().getName(), SecurityContextHolder.getLocal2());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
