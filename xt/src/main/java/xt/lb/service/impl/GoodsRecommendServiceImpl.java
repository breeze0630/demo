package xt.lb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xt.lb.dao.ShopGoodsMapper;
import xt.lb.dao.ShopGoodsSellMapper;
import xt.lb.dto.WebDto;
import xt.lb.entity.ShopGoodsSell;

@Service("goodsRecommendServiceImpl")
public class GoodsRecommendServiceImpl {
	@Autowired
	ShopGoodsMapper shopGoodsMapper;
	@Autowired
	ShopGoodsSellMapper shopGoodsSellMapper;
	/**
	 * 查询所有商品
	 * */
	public WebDto query(WebDto inDto) {
		WebDto out = new WebDto();
		ShopGoodsSell shopGoodsSell = new ShopGoodsSell();
		shopGoodsSell.setUserId(inDto.getUserId());
		shopGoodsSell.setShopId(inDto.getShopId());
		//筛选出销量最高的四件商品，作为品牌推荐
		ArrayList<ShopGoodsSell> list = shopGoodsSellMapper.selectOrder();
		if(list == null || list.size() == 0){
			out.setStatus("1");
			out.setLoggerMessage("查询失败");
		}else{
			out.setStatus("0");
			out.setShopGoodsSellList(list);
			out.setLoggerMessage("查询成功");
		}
		return out;
	}

}
