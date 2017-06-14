package xt.lb.entity;

import java.sql.Timestamp;

public class News {
	//用户消息
	private String messageId;
	private String userName;
	private String fromName;
	private String toName;
	private String messageType;
	private String message;
	private String lookStatus;
	private Timestamp messageTime;
	// 0--> 已读   1-->未读
	private String messageStatus;
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
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
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public Timestamp getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}
	public String getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	public String getLookStatus() {
		return lookStatus;
	}
	public void setLookStatus(String lookStatus) {
		this.lookStatus = lookStatus;
	}
	
	
}
