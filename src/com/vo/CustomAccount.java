package com.vo;

/**
 * 创建客服 
 * @author Ruby
 *
 */
public class CustomAccount {
	/* "kf_account" : "test1@test",
    "nickname" : "客服1",
    "password" : "96e79218965eb72c92a549dd5a330112"*/
	//用户名
	private String kf_account;
	//昵称
	private String nickname;
	//密码
	private String password;
	public String getKf_account() {
		return kf_account;
	}
	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
