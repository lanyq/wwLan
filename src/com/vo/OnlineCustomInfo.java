package com.vo;

/**
 * 在线客服信息
 * @author Ruby
 *
 */
public class OnlineCustomInfo {
	//客服账号
	private String kf_account;
	//状态
	private int status;
	//工号
	private String kf_id;
	//最大接入数
	private int auto_accept;
	//接待客户数
	private int accepted_case;
	public String getKf_account() {
		return kf_account;
	}
	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getKf_id() {
		return kf_id;
	}
	public void setKf_id(String kf_id) {
		this.kf_id = kf_id;
	}
	public int getAuto_accept() {
		return auto_accept;
	}
	public void setAuto_accept(int auto_accept) {
		this.auto_accept = auto_accept;
	}
	public int getAccepted_case() {
		return accepted_case;
	}
	public void setAccepted_case(int accepted_case) {
		this.accepted_case = accepted_case;
	}
	
	
}
