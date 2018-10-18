package com.entity;

import java.sql.Blob;
import java.util.Date;

public class QRRelateInfo {

	
	private String id;//主键
	
	
	private String chinese;//汉字
	
	private String link;//链接
	
	private String qrCode;//二维码图片
	
	private String video;//视频路径
	
	private String qrId;//二维码的ID，二维码的参数值
	
	private String upUser;//上传人
	
	
	private Date uploadTime;//上传时间
	
	private Date updateTime;//修改时间
	
	private String deleteFlag;//删除标记（0：未删除，1：已删除）
	
	private String tmp1;//备用字段1
	
	
	private String tmp2;//备用字段2


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getChinese() {
		return chinese;
	}


	public void setChinese(String chinese) {
		this.chinese = chinese;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getQrCode() {
		return qrCode;
	}


	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}


	public String getVideo() {
		return video;
	}


	public void setVideo(String video) {
		this.video = video;
	}


	public String getQrId() {
		return qrId;
	}


	public void setQrId(String qrId) {
		this.qrId = qrId;
	}


	public String getUpUser() {
		return upUser;
	}


	public void setUpUser(String upUser) {
		this.upUser = upUser;
	}


	public Date getUploadTime() {
		return uploadTime;
	}


	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getDeleteFlag() {
		return deleteFlag;
	}


	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public String getTmp1() {
		return tmp1;
	}


	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}


	public String getTmp2() {
		return tmp2;
	}


	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	
}
