package xt.lb.dao;

import java.util.ArrayList;

import xt.lb.entity.UserCar;

public interface UserCarMapper {
	ArrayList<UserCar> selectAllByUserId(UserCar userCar);
	ArrayList<UserCar> selectByUserShop(UserCar userCar);
	int insert(UserCar userCar);
	
	int  delete(UserCar userCar);
	
	int	update(UserCar userCar);

	
}
