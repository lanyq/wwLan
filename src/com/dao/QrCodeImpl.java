package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.QRRelateInfo;
import com.util.DBconn;

public class QrCodeImpl implements QrCodeDao{

	public List<QRRelateInfo> getQrCodeList(String qrId) {
		// TODO Auto-generated method stub
		List<QRRelateInfo> list=new ArrayList<QRRelateInfo>();
		try {
		    DBconn.init();
		    ResultSet rs = DBconn.selectSql("select * from wc_ticket where qrId='"+qrId+"'");
			while(rs.next()){
				QRRelateInfo qrInfo=new QRRelateInfo();
				qrInfo.setId(rs.getString("id"));
				qrInfo.setLink(rs.getString("link"));
				qrInfo.setQrCode(rs.getString("qrCode"));
				qrInfo.setVideo(rs.getString("video"));
				qrInfo.setQrId(rs.getString("qrId"));
				qrInfo.setUpUser(rs.getString("upUser"));
				qrInfo.setUploadTime(rs.getDate("uploadTime"));
				qrInfo.setUpdateTime(rs.getDate("updateTime"));
				qrInfo.setDeleteFlag(rs.getString("deleteFlag"));
				qrInfo.setTmp1(rs.getString("tmp1"));
				qrInfo.setTmp2(rs.getString("tmp2"));
				list.add(qrInfo);
			}
			DBconn.closeConn();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return list;
	}

	
	public QRRelateInfo getQrCodeInfo(String qrId) {
		// TODO Auto-generated method stub
		List<QRRelateInfo> list=new ArrayList<QRRelateInfo>();
		QRRelateInfo qrInfo=new QRRelateInfo();
		try {
		    DBconn.init();
		    ResultSet rs = DBconn.selectSql("select * from wc_ticket where qrId='"+qrId+"'");
			while(rs.next()){
				qrInfo.setId(rs.getString("id"));
				qrInfo.setLink(rs.getString("link"));
				qrInfo.setQrCode(rs.getString("qrCode"));
				qrInfo.setVideo(rs.getString("video"));
				qrInfo.setQrId(rs.getString("qrId"));
				qrInfo.setUpUser(rs.getString("upUser"));
				qrInfo.setUploadTime(rs.getDate("uploadTime"));
				qrInfo.setUpdateTime(rs.getDate("updateTime"));
				qrInfo.setDeleteFlag(rs.getString("deleteFlag"));
				qrInfo.setTmp1(rs.getString("tmp1"));
				qrInfo.setTmp2(rs.getString("tmp2"));
				list.add(qrInfo);
			}
			if(null!=list&&!list.isEmpty()&&list.size()>0){
				return list.get(0);
			}
			DBconn.closeConn();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return qrInfo;
	}
}
