package xt.lb.entity;

import java.sql.Date;

public class ShopInfo {
//商店的具体信息
	private String shopId;
	
	private String shopName;
	
	private Date shopCreateTime; 
	
	private String shopAddress;
	
	private String shopDesc;

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
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

	public Date getShopCreateTime() {
		return shopCreateTime;
	}

	public void setShopCreateTime(Date shopCreateTime) {
		this.shopCreateTime = shopCreateTime;
	}
	
	
}
