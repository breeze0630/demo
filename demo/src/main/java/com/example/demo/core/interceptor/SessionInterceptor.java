package com.example.demo.core.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/3/21.
 */
public class SessionInterceptor implements HandlerInterceptor
{

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o) throws Exception
	{
		if(httpServletRequest.getRequestURI().equals("/login") || httpServletRequest.getRequestURI().equals("/loginValida"))
		{
			return true;
		}

		Object obj = httpServletRequest.getSession().getAttribute("_session_user");
		if(obj == null)
		{
			httpServletResponse.sendRedirect("/login");
			return false;
		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, ModelAndView modelAndView) throws Exception
	{

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
	{

	}
}
