package xt.lb.entity;

import java.sql.Timestamp;

public class ShopGoodsSell {
	//销售单
	private String userId;//购买者id
	private String shopId;//商店id
	private String goodsId;//商品id
	private Integer amount;//銷售數量
	private double price;//销售价格
	private double rental;//总额
	private Timestamp time;//成交时间,精确到毫秒
	private String isDict;
	private String dict;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRental() {
		return rental;
	}
	public void setRental(double rental) {
		this.rental = rental;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
