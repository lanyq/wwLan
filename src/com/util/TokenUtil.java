package com.util;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.entity.Token;

public class TokenUtil {

	
	public static boolean saveToken(Token accessToken){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime=sdf.format(new Date());
		boolean flag=false;
		try{
			DBconn.init();
			int i =DBconn.addUpdDel("insert into t_token(access_token,expires_in,create_time) " +
					"values('"+accessToken.getAccessToken()+"','"+accessToken.getExpiresIn()+"',to_date('"+createTime+"','YYYY-MM-DD HH24:MI:SS'))");
			if(i>0){
				flag=true;
			}
			DBconn.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
}
