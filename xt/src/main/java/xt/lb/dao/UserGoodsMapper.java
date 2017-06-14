package xt.lb.dao;

import java.util.ArrayList;

import xt.lb.entity.UserGoods;

public interface UserGoodsMapper {

ArrayList<UserGoods> selectByUserId(UserGoods userGoods);
	
	int insert(UserGoods userGoods);
	
	int  delete(UserGoods userGoods);
	
	int	update(UserGoods userGoods);
}
