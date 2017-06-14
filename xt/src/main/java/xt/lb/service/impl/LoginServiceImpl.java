package xt.lb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xt.lb.dao.UserCarMapper;
import xt.lb.dao.UserCommonInfoMapper;
import xt.lb.dto.WebDto;
import xt.lb.entity.UserCommonInfo;
import xt.lb.service.BaseService;

@Service("loginServiceImpl")
public class LoginServiceImpl implements BaseService {
	
	@Autowired
	public  UserCommonInfoMapper userCommonInfoMapper;
	@Autowired
	private UserCarMapper userCarMapper;
	public WebDto loginService(WebDto inDto){
		//调用db，查询用户名及密码
		UserCommonInfo userCommonInfo = new UserCommonInfo();
		userCommonInfo.setUserName(inDto.getUserName());
		userCommonInfo.setPassword(inDto.getPassword());
		System.out.println(userCommonInfo.getUserName());
		System.out.println(userCommonInfo.getPassword());
		
		int result = userCommonInfoMapper.selectForLogin(userCommonInfo);
		
	
		//当result == 0 时，用户登录失败
		
		WebDto outDto = new WebDto();
		if(result == 0){
			outDto.setStatus("1");
			return outDto;
		}
		// result == 1时。用户登录成功
		//登录成功后，查询用户的基本信息,
		outDto.setStatus("0");
		UserCommonInfo user= userCommonInfoMapper.selectByUserName(userCommonInfo.getUserName());
		outDto.setUserId(user.getUserId());
		outDto.setUserName(user.getUserName());
		outDto.setHasShop(user.getHasShop());
		return outDto;
		
	}
	
	
	public WebDto registService(WebDto inDto){
		UserCommonInfo user= new UserCommonInfo();
		WebDto outDto = new WebDto();
		user.setUserName(inDto.getUserName());
		if(userCommonInfoMapper.selectNumbleByUserName(inDto.getUserName())==1){
			//进行数据库查询此用户名是否已存在，存在时 == 1 即 设置regist_st = 1
			outDto.setRegist_st("1");
			return outDto;
		}
		
		user.setPassword(inDto.getPassword());
		user.setPhoneNo(inDto.getPhoneNo());
		user.setSex(inDto.getSex());
		user.setCityName(inDto.getCityName());
		user.setHasShop("1");
		int result = userCommonInfoMapper.insertUser(user);
		if(result==1){
			//ok
			UserCommonInfo innerUser = userCommonInfoMapper.selectByUserName(inDto.getUserName());
			outDto.setUserName(innerUser.getUserName());
			outDto.setUserId(innerUser.getUserId());
		}
		outDto.setRegist_st("1");
		return outDto;
	}

}
