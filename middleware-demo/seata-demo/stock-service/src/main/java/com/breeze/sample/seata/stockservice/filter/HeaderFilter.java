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
        /**
         * seata 的全局事物的控制，就是通过 请求时，header 传递 TX_XID，默认设置为 存在TX_XID即使用现有xid，否则生成新的xid
         * 在  SeataHandlerInterceptor 中 通过   RootContext.bind(rpcXid) 将 TX_XID 绑定到 RootContext.XID 中
         * RootContext.getXID()
         */
        String xid = ((HttpServletRequest)servletRequest).getHeader("TX_XID");
        log.info("HeaderFilter.xid:{}",xid);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
