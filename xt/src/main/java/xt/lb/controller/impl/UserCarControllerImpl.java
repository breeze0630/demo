package xt.lb.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xt.lb.dto.WebDto;
import xt.lb.service.impl.UserCarServiceImpl;
@Controller
@RequestMapping("/userCar")
public class UserCarControllerImpl {
	
	@Autowired
	UserCarServiceImpl userCarServiceImpl;
	
	@RequestMapping(value="/addShop")
	public void addShop(WebDto inDto){
		
		userCarServiceImpl.addShop(inDto);
		
		
	}
}
