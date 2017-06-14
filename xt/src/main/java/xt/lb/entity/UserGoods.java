package xt.lb.entity;

import java.sql.Timestamp;

public class UserGoods {
	//好吧，是账单。。。
	private String userId;
	private String shopId;
	private String goodsId;
	private int goodsAmount;
	private Timestamp tradeTime;
	private String evaluteStatus;
	private String evaluteType;
	private String evalute;
	private String addEvaStatus;
	private String addEva;
	private Timestamp addEvaTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	public int getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(int goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	public Timestamp getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Timestamp tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getEvaluteStatus() {
		return evaluteStatus;
	}
	public void setEvaluteStatus(String evaluteStatus) {
		this.evaluteStatus = evaluteStatus;
	}
	public String getEvaluteType() {
		return evaluteType;
	}
	public void setEvaluteType(String evaluteType) {
		this.evaluteType = evaluteType;
	}
	public String getEvalute() {
		return evalute;
	}
	public void setEvalute(String evalute) {
		this.evalute = evalute;
	}
	public String getAddEvaStatus() {
		return addEvaStatus;
	}
	public void setAddEvaStatus(String addEvaStatus) {
		this.addEvaStatus = addEvaStatus;
	}
	public String getAddEva() {
		return addEva;
	}
	public void setAddEva(String addEva) {
		this.addEva = addEva;
	}
	public Timestamp getAddEvaTime() {
		return addEvaTime;
	}
	public void setAddEvaTime(Timestamp addEvaTime) {
		this.addEvaTime = addEvaTime;
	}
	
	
}
