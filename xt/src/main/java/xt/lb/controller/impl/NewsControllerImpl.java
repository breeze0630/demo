package xt.lb.controller.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xt.lb.controller.businessController;
import xt.lb.dto.WebDto;
import xt.lb.service.impl.NewsServiceImpl;
@Controller
@RequestMapping("/news")
public class NewsControllerImpl implements businessController {

	@Autowired
	private NewsServiceImpl newsServiceImpl;
	
	@RequestMapping(value="/query")
	@ResponseBody
	public ModelAndView queryNews(WebDto inDto){
		System.out.println("----news/query");
		ModelAndView mav = new ModelAndView();
		
		HashMap<String,WebDto> map = new HashMap<String,WebDto>();
		map.put("webDto",newsServiceImpl.queryNews(inDto));
		mav.addAllObjects(map);
		mav.setViewName("/xt/page/news.jsp");
		return mav;
	}
	 
	@RequestMapping(value="/news/remove")
	@ResponseBody
	public ModelAndView removeNews(WebDto inDto){
		ModelAndView mav = new ModelAndView();
		HashMap<String,WebDto> map = new HashMap<String,WebDto>();
		map.put("webDto", newsServiceImpl.removeNews(inDto));
		mav.addAllObjects(map);
		return mav;
	}
	@RequestMapping(value="/news/answer")
	@ResponseBody
	public HashMap<String,WebDto> answerNews(WebDto inDto){
		HashMap<String,WebDto> map = new HashMap<String,WebDto>();
		map.put("webDto",newsServiceImpl.answerNews(inDto));
		return map;
	}
	@RequestMapping(value="/news/add")
	@ResponseBody
	public HashMap<String,WebDto> addNews(WebDto inDto){
		HashMap<String,WebDto> map = new HashMap<String,WebDto>();
		map.put("webDto",newsServiceImpl.addNews(inDto));
		return map;
		
	}
	
	
}
