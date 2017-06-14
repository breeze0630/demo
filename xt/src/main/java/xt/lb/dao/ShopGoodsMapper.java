package xt.lb.dao;

import java.util.ArrayList;

import xt.lb.entity.ShopGoods;

public interface ShopGoodsMapper {

	/**
	 * 查询某商铺已上架商品信息列表
	 * @param shopGoods
	 * @return ArrayList<ShopGoods>
	 * */
	ArrayList<ShopGoods> selectByShopId(ShopGoods shopGoods);
	
	/**
	 * 查询商铺某件商品剩余库存
	 * @param shopGoods
	 * */
	int selectAmount(ShopGoods shopGoods);
	
	
	/**
	 * 商铺添加(上架)新商品
	 * @param shopGoods
	 * 
	 * */
	int insert(ShopGoods shopGoods);
	/**
	 * 商铺删除(下架)商品
	 * @param shopGoods
	 * 
	 * */
	int  deleteByShopAndGoodsId(ShopGoods shopGoods);
	/**
	 * 整个商铺删除(下架)商品
	 * @param shopGoods
	 * 
	 * */
	int  deleteByShopId(ShopGoods shopGoods);
	/**
	 * 更新商铺某件商品的状态信息
	 * @param shopGoods
	 * */
	int	update(ShopGoods shopGoods);
	
}
