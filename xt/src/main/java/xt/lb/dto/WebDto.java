package xt.lb.dto;

import java.util.ArrayList;
import java.util.Date;

import xt.lb.entity.News;
import xt.lb.entity.ShopGoods;
import xt.lb.entity.ShopGoodsSell;

public class WebDto {
	//1==失败  0==成功
	private String status;
	private String loggerMessage;
	private String regist_st;
	private ArrayList<News> news;
	private ArrayList<GoodsList> CarList;
	private String opea;
	private String inCar;
	//userCommonInfo
	private String userId;
	private String userName;
	private String password;
	private String phoneNo;
	private String 	sex;
	private String cityName;
	private String address;
	private String hasShop;
	private String shopId;
	
	//goodsInfo
	private String goodsId;
	private String goodsName;
	private String goodsPrice;
	private String goodsDesc;
	private String goodsPhotoPath;
	private String hasGoodsPhoto;
	//shopGoods
	private String amount;
	private String isDict;
	private String dict;
	private ArrayList<ShopGoods> shopGoodsList;
	private ArrayList<ShopGoodsSell> shopGoodsSellList;
	//userShop
	private Date startTime;
	private Date runStart;
	private Date runEnd;
	
	//shopInfo
	private String shopName;
	private String shopAddress;
	private String shopDesc;
	


	//news
	private String messageId;
	private String fromName;
	private String toName;
	private String messageType;
	private String messageTime;
	private String message;
	private String messageStatus;
	//userGoods
	private int goodsAmount;
	private String tradeTime;
	private String evaluteStatus;
	private String evaluteType;
	private String evalute;
	private String addEvaStatus;
	private String addEva;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoggerMessage() {
		return loggerMessage;
	}

	public void setLoggerMessage(String loggerMessage) {
		this.loggerMessage = loggerMessage;
	}
	
	public String getRegist_st() {
		return regist_st;
	}
	public void setRegist_st(String regist_st) {
		this.regist_st = regist_st;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHasShop() {
		return hasShop;
	}
	public void setHasShop(String hasShop) {
		this.hasShop = hasShop;
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
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDescc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getRunStart() {
		return runStart;
	}
	public void setRunStart(Date runStart) {
		this.runStart = runStart;
	}
	public Date getRunEnd() {
		return runEnd;
	}
	public void setRunEnd(Date runEnd) {
		this.runEnd = runEnd;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopDesc() {
		return shopDesc;
	}
	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(int goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
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
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public ArrayList<News> getNews() {
		return news;
	}
	public void setNews(ArrayList<News> news) {
		this.news = news;
	}
	public ArrayList<GoodsList> getCarList() {
		return CarList;
	}
	public void setCarList(ArrayList<GoodsList> carList) {
		CarList = carList;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getOpea() {
		return opea;
	}
	public void setOpea(String opea) {
		this.opea = opea;
	}
	
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	public String getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	public String getGoodsPhotoPath() {
		return goodsPhotoPath;
	}
	public void setGoodsPhotoPath(String goodsPhotoPath) {
		this.goodsPhotoPath = goodsPhotoPath;
	}
	public String getHasGoodsPhoto() {
		return hasGoodsPhoto;
	}
	public void setHasGoodsPhoto(String hasGoodsPhoto) {
		this.hasGoodsPhoto = hasGoodsPhoto;
	}
	public ArrayList<ShopGoods> getShopGoodsList() {
		return shopGoodsList;
	}
	public void setShopGoodsList(ArrayList<ShopGoods> shopGoodsList) {
		this.shopGoodsList = shopGoodsList;
	}
	public String getInCar() {
		return inCar;
	}
	public void setInCar(String inCar) {
		this.inCar = inCar;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getIsDict() {
		return isDict;
	}
	public void setIsDict(String isDict) {
		this.isDict = isDict;
	}
	public String getDict() {
		return dict;
	}
	public void setDict(String dict) {
		this.dict = dict;
	}
	public ArrayList<ShopGoodsSell> getShopGoodsSellList() {
		return shopGoodsSellList;
	}
	public void setShopGoodsSellList(ArrayList<ShopGoodsSell> shopGoodsSellList) {
		this.shopGoodsSellList = shopGoodsSellList;
	}
	
	
}
