package com.breeze.sample.seata.stockservice.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @auther: liubiao
 * @date: 2024-12-13
 */
@Component
@Slf4j
public class HeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String xid = ((HttpServletRequest)servletRequest).getHeader("TX_XID");
        log.info("HeaderFilter.xid:{}",xid);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
