package xt.lb.dao;

import java.util.List;

import xt.lb.entity.UserCommonInfo;

public interface UserCommonInfoMapper {
	
	UserCommonInfo	selectByUserId(UserCommonInfo userCommonInfo);
	
	UserCommonInfo selectByUserName(String userName);
	
	int selectNumbleByUserName(String userName);
	int selectNumbleByUserId(String userId);
	List<UserCommonInfo> selectAll();
	
	int selectForLogin(UserCommonInfo userCommonInfo);
	
	int insertUser(UserCommonInfo userCommonInfo);
	
	int deleteByUserId(String userId);
	
	int updateByUserId(UserCommonInfo userCommonInfo);
}
