package xt.lb.service.impl;

import java.sql.Timestamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xt.lb.dao.ShopGoodsMapper;
import xt.lb.dao.ShopGoodsSellMapper;
import xt.lb.dao.ShopInfoMapper;
import xt.lb.dao.UserCarMapper;
import xt.lb.dao.UserGoodsMapper;
import xt.lb.dto.WebDto;
import xt.lb.entity.ShopGoods;
import xt.lb.entity.ShopGoodsSell;
import xt.lb.entity.UserCar;
import xt.lb.entity.UserGoods;
@Service("shoppingServiceImpl")
public class ShoppingServiceImpl {
	@Autowired
	ShopInfoMapper shopInfoMapper;
	@Autowired
	UserCarMapper userCarMapper;
	@Autowired
	UserGoodsMapper userGoodsMapper;
	@Autowired
	ShopGoodsMapper shopGoodsMapper;
	@Autowired
	ShopGoodsSellMapper shopGoodsSellMapper;

	/**
	 * 购物实现
	 */
	public WebDto shopping(WebDto inDto) {
		WebDto out = new WebDto();
		UserCar userCar = new UserCar();
		UserGoods userGoods = new UserGoods();
		ShopGoods shopGoods = new ShopGoods();
		ShopGoodsSell shopGoodsSell = new ShopGoodsSell();
		// 首先获取shopid和goodsid，查询商家待售商品数量足够
		shopGoods.setShopId(inDto.getShopId());
		shopGoods.setGoodsId(inDto.getGoodsId());
		int gAmount = shopGoodsMapper.selectAmount(shopGoods);
		if (Integer.parseInt(inDto.getAmount()) <= gAmount) {

			userGoods.setUserId(inDto.getUserId());
			userGoods.setShopId(inDto.getShopId());
			userGoods.setGoodsId(inDto.getGoodsId());
			Timestamp time = new Timestamp(System.currentTimeMillis());
			userGoods.setTradeTime(time);
			userGoods.setGoodsAmount(inDto.getGoodsAmount());
			userGoods.setEvaluteStatus("1");
			userGoods.setAddEvaStatus("1");

			// 设置购物后的商店商品信息
			shopGoods.setShopId(inDto.getShopId());
			shopGoods.setGoodsId(inDto.getGoodsId());
			shopGoods.setAmount(gAmount - inDto.getGoodsAmount());
			// 生成购物记录，记录购物详情
			shopGoodsSell.setUserId(inDto.getUserId());
			shopGoodsSell.setShopId(inDto.getShopId());
			shopGoodsSell.setGoodsId(inDto.getGoodsId());
			shopGoodsSell.setTime(time);
			shopGoodsSell.setPrice(Double.parseDouble(inDto.getGoodsPrice()));
			shopGoodsSell.setIsDict(inDto.getIsDict());
			shopGoodsSell.setDict(inDto.getDict());
			shopGoodsSell.setAmount(inDto.getGoodsAmount());
			shopGoodsSell.setRental(Double.parseDouble(inDto.getGoodsPrice()) * inDto.getGoodsAmount());
			if (inDto.getInCar() != null) {
				userCar.setGoodsId(inDto.getGoodsId());
				userCar.setShopId(inDto.getShopId());
				userCar.setUserId(inDto.getUserId());

				if (userCarMapper.delete(userCar) > 0 && userGoodsMapper.insert(userGoods) > 0
						&& shopGoodsMapper.update(shopGoods) > 0 && shopGoodsSellMapper.insert(shopGoodsSell) > 0) {
					// 只有当几个数据库执行成功，才被认为是购物成功，但是这里没有对数据库设置事物，当仅仅执行了部分数据库操作就被停止时，不能回滚数据，需要优化
					out.setStatus("0");
					out.setLoggerMessage("购物成功");
					return out;
				}
			}
		}
		out.setStatus("1");
		out.setLoggerMessage("由于商品数量不足，购物失败，请重新购买");

		return out;
	}
}
