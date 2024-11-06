package com.example.mybatisplusexample.conf;

import brave.Span;
import brave.Tracing;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

import java.io.IOException;

import static com.example.mybatisplusexample.conf.SysConstant.TRACE_ID;


/**
 * @author Joker
 * @version 1.0.0
 * @since 2024-07-17
 * 描述:
 */
@Component
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
   /*     Span currentSpan = Tracing.currentTracer().currentSpan(); // 获取当前 span
        if (currentSpan != null) {
            String traceId = currentSpan.context().traceIdString();
            String spanId = currentSpan.context().spanIdString();
        }*/
        try {


            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String traceId = servletRequest.getHeader(TRACE_ID);
            if (StrUtil.isBlank(traceId)) {
                traceId = IdUtil.fastSimpleUUID();
            }
            request.setAttribute(TRACE_ID, traceId);
            MDC.put(TRACE_ID, traceId);
            filterChain.doFilter(request, response);

            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.setHeader(TRACE_ID, traceId);
        }catch (Exception e){

        }finally {
            MDC.remove(TRACE_ID);
        }

    }

 /*   @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String traceId = request.getHeader(TRACE_ID);
        if(StrUtil.isBlank(traceId)){
            traceId = IdUtil.fastSimpleUUID();
        }
        request.setAttribute(TRACE_ID, traceId);
        MDC.put(TRACE_ID, traceId);
        response.setHeader(TRACE_ID, traceId);
        return true;
    }*/

/*    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        // 请求处理之后，视图渲染之前执行的代码
        MDC.remove(TRACE_ID);
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
        MDC.remove(TRACE_ID);
    }*/
}
