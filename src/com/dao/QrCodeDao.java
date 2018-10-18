package com.dao;

import java.util.List;

import com.entity.QRRelateInfo;

public interface QrCodeDao {

	public List<QRRelateInfo> getQrCodeList(String qrId);
	
	public QRRelateInfo getQrCodeInfo(String qrId);
	
}
