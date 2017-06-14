package xt.lb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xt.lb.dto.WebDto;
import xt.lb.service.impl.EvaluteServiceImpl;

public class EvaluteControllerImpl {
	@Autowired
	EvaluteServiceImpl evaluteServiceImpl;
	@RequestMapping(value="/evalute/add")
	public WebDto addevalute(WebDto inDto){
		
		
		return evaluteServiceImpl.createEvalute(inDto);
		
	}
}
