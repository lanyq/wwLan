package com.entity;

public class QRcode {

	
	private String ticket;//获取的二维码
	
	private int expire_seconds; //二维码的有效时间,单位为秒,最大不超过2592000（即30天）

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public int getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(int expireSeconds) {
		expire_seconds = expireSeconds;
	}
	
	
}
