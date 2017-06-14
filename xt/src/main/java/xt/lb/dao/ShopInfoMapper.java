package xt.lb.dao;

import java.util.ArrayList;

import xt.lb.entity.ShopInfo;

public interface ShopInfoMapper {
ArrayList<ShopInfo> selectByUserId(ShopInfo shopInfo);
	
	int insert(ShopInfo shopInfo);
	
	int  delete(ShopInfo shopInfo);
	
	int	update(ShopInfo shopInfo);
}
