package com.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * openid_list 用户openid实体类
 * 
 * @author jack
 * @version 1.0
 *
 */
public class OpenidList
{
	//用户openid列表
	private List openid_list = new ArrayList();

	//目的用户组编号
	private int to_groupid;

	public List getOpenid_list() {
		return openid_list;
	}

	public void setOpenid_list(List openid_list) {
		this.openid_list = openid_list;
	}

	public int getTo_groupid() {
		return to_groupid;
	}

	public void setTo_groupid(int to_groupid) {
		this.to_groupid = to_groupid;
	}	
}
