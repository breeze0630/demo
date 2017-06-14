package xt.lb.entity;

import java.sql.Time;
import java.util.Date;

public class UserShop {

	//用户的商店信息
	private String userId;
	
	private String shopId;
	
	private Date startTime;
	
	private Time runStart;
	
	private Time runEnd;
	
	private String isRun;

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Time getRunStart() {
		return runStart;
	}

	public void setRunStart(Time runStart) {
		this.runStart = runStart;
	}

	public Time getRunEnd() {
		return runEnd;
	}

	public void setRunEnd(Time runEnd) {
		this.runEnd = runEnd;
	}

	public String getIsRun() {
		return isRun;
	}

	public void setIsRun(String isRun) {
		this.isRun = isRun;
	}
	
	
}
