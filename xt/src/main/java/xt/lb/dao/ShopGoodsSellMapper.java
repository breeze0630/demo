package xt.lb.dao;

import java.util.ArrayList;

import xt.lb.entity.ShopGoodsSell;

public interface ShopGoodsSellMapper {

	int insert(ShopGoodsSell shopGoodsSell);
	
	/**
	 * 推荐列表
	 * 
	 * */
	ShopGoodsSell selectAmount(ShopGoodsSell shopGoodsSell);
	ArrayList<ShopGoodsSell> selectOrder();
	int update(ShopGoodsSell shopGoodsSell);

	
}
