package xt.lb.entity;

import java.sql.Date;

public class ShopGoods {
	// 商店待售产品信息表
	private String shopId;
	private String goodsId;
	// 商品数量
	private int amount;
	private String name;
	// 是否有折扣
	private String isDict;
	// 折扣
	private String dict;
	// 商品售卖状态
	private String isSell;
	// 上架时间
	private Date onTime;
	// 在本商店内的售价
	private double goods_price;

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDict() {
		return dict;
	}

	public void setDict(String dict) {
		this.dict = dict;
	}

	public String getIsDict() {
		return isDict;
	}

	public void setIsDict(String isDict) {
		this.isDict = isDict;
	}

	public String getIsSell() {
		return isSell;
	}

	public void setIsSell(String isSell) {
		this.isSell = isSell;
	}

	public Date getOnTime() {
		return onTime;
	}

	public void setOnTime(Date onTime) {
		this.onTime = onTime;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

}
