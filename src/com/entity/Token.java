package com.entity;

/**
 * token令牌类
 * @author LAN
 *
 */
public class Token {

	
	private int expiresIn;//token有效期
	
	
	private String accessToken;//token令牌


	public int getExpiresIn() {
		return expiresIn;
	}


	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
	
	
}
