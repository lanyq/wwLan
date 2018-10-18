package com.vo;

/**
 * 获取客服基本信息
 * @author Ruby
 *
 */
public class CustomeInfo {

	/* 
	 *    "kf_account" : "test1@test",
          "kf_headimgurl" : "http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjfUS8Ym0GSaLic0FD3vN0V8PILcibEGb2fPfEOmw/0",
          "kf_id" : "1001",
          "kf_nick" : "ntest1
	 * */
	//账号
	private String kf_account;
	//头像url
	private String kf_headimgurl;
	//工号
	private String kf_id;
	//昵称
	private String kf_nick;
	public String getKf_account() {
		return kf_account;
	}
	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}
	public String getKf_headimgurl() {
		return kf_headimgurl;
	}
	public void setKf_headimgurl(String kf_headimgurl) {
		this.kf_headimgurl = kf_headimgurl;
	}
	public String getKf_id() {
		return kf_id;
	}
	public void setKf_id(String kf_id) {
		this.kf_id = kf_id;
	}
	public String getKf_nick() {
		return kf_nick;
	}
	public void setKf_nick(String kf_nick) {
		this.kf_nick = kf_nick;
	}
}
