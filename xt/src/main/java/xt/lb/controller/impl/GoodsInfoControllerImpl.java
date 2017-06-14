package xt.lb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xt.lb.controller.businessController;
import xt.lb.dto.WebDto;
import xt.lb.service.impl.GoodsInfoServiceImpl;

public class GoodsInfoControllerImpl implements businessController {
	@Autowired
	GoodsInfoServiceImpl goodsInfoServiceImpl;
	@RequestMapping(value="/goods/add")
	public void addGoods(WebDto inDto){
		goodsInfoServiceImpl.addGoods(inDto);
	}
}
