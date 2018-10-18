package com.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信服务器列表
 * 
 * @author jack
 * @version 1.0
 *
 */
public class WeixinServer
{
	//微信服务器列表
	private List ip_list= new ArrayList();

	public List getIp_list() {
		return ip_list;
	}

	public void setIp_list(List ip_list) {
		this.ip_list = ip_list;
	}
}
