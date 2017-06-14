package xt.lb.controller.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import xt.lb.dto.WebDto;
import xt.lb.service.impl.LoginServiceImpl;
@Controller
@RequestMapping("/account")
public class LoginControllerImpl {

	@Autowired
	public  LoginServiceImpl loginServiceImpl;
	
	@RequestMapping(value="/login")
	@ResponseBody
	public  ModelAndView login(WebDto webDto) {
	
		System.out.println("-----------------");
		ModelAndView mav = new ModelAndView();
		 webDto= loginServiceImpl.loginService(webDto);
	//	mav.addObject("webDto", out);
		
		if("0".equals(webDto.getStatus())){
			//登录成功，切换至index.jsp
			System.out.print("OK");
			//mav.setViewName("/index.jsp");
			mav.setView(new RedirectView("/xt/page/regist.jsp"));
			
			mav.addObject("webDto",webDto);
			System.out.println("--" + webDto.getUserName());
			return mav;
		}else{
			//失败，回到原先的login.jsp
			System.out.print("NG");
			mav.setViewName("/xt/page/login.jsp");
			mav.addObject("webDto",webDto);
			return mav;
		}
	}
	@RequestMapping("/regist")
	public  String regist(ModelMap modelMap,WebDto webDto) {
		WebDto outDto = loginServiceImpl.registService(webDto);
		modelMap.addAttribute("webDto", outDto);
		
		if("1".equals(outDto.getRegist_st())){
			//注册失败
			System.out.print("NG");
			return "/xt/page/regist.jsp";			
		}else{
			//注册成功，跳转到首页，并携带用户名信息，
			System.out.print("OK");
			return "/xt/index.jsp";
			
		}
	}

	@RequestMapping("/test")
	public String test(){
		/*WebDto webDto = new WebDto();
		webDto.setUserName("tom");
		
		loginServiceImpl.loginService(webDto);*/
		System.out.println("-----------------");
		return "/index";
	}

}
