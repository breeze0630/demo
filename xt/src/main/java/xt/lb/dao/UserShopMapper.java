package xt.lb.dao;


import xt.lb.entity.UserShop;

public interface UserShopMapper {
	UserShop selectByUserId(UserShop userGoods);
	String selectShopNameByShopId(String shopId);
	int insert(UserShop userGoods);
	
	int  delete(UserShop userGoods);
	
	int	update(UserShop userGoods);
}
