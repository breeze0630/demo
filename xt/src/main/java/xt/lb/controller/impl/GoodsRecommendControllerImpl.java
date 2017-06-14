package xt.lb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xt.lb.dto.WebDto;
import xt.lb.service.impl.GoodsRecommendServiceImpl;

public class GoodsRecommendControllerImpl {

	@Autowired
	GoodsRecommendServiceImpl goodsRecommendServiceImpl;
	
	@RequestMapping(value="/recommend/goods")
	public WebDto initRecommend(WebDto inDto){
		WebDto out =new WebDto();
		goodsRecommendServiceImpl.query(inDto);
		return out;
	}
	
}
