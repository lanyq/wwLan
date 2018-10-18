package com.vo;


/**
 * 分组信息实体类
 * 
 * @author jack
 * @version 1.0
 *
 */
public class WeixinGroup 
{
	//分组编号
	private int id;
	//分组名称
	private String name;
	//组内用户数
	private int count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
