package com.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;

import com.constant.WeixinConstants;
import com.util.WeixinUtil;

import net.sf.json.JSONObject;

/**
 * @author Leon
 * 创建永久二维码，并下载获取二维码的服务类
 * @param accessToken  
 * @param sceneId场景iD    1~100000
 * @return
 */
public class QRcodeService {

	private static Logger logger=Logger.getLogger(QRcodeService.class);
	public static String createForeverTicket(String accessToken,int sceneId){
		String ticket = null;
		//发送请求的地址url 
		String requestUrl ="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
		requestUrl = requestUrl.replace("TOKEN", accessToken);
		
		String jsonmsg = "{\"action_name\": \"QR_LIMIT_SCENE\",\"action_info\":{\"scene\":{\"scene_id\":%d}}}";
		
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "POST", String.format(jsonmsg, sceneId));
		if (null != jsonObject){
			logger.info("返回json对象:"+jsonObject);
			try{
				ticket = jsonObject.getString("ticket");
				logger.info("永久二维码ticket创建成功"+ticket);
				System.out.println("永久带参二维码ticket成功=" + ticket);
			}catch(Exception e){
				int err = jsonObject.getInt("errcode");
				String errormsg = jsonObject.getString("errmsg");
				logger.error("永久二维码ticket创建失败，失败类型编号:"+err+"失败原因:"+errormsg);
			}
			
		}
		return  ticket;
		
	}
	
	
	
	
	
	/**@desc 保存二维码
	 * @time 2018-10-12
	 * @param ticket
	 * @param savepath 存放服务器的二维码路径
	 * @return
	 */
	public static String getRQcode(String ticket, String savepath){
		String filepath = null;
		String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
		try{
			requestUrl = requestUrl.replace("TICKET", WeixinUtil.urlencodeutf8(ticket));
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
 
			if (!savepath.endsWith("/")){
				savepath += "/";
			}
			// 将ticket 作为文件名
			filepath = savepath + ticket + ".jpg";
 
			// 将微信服务器返回的输入流写入文件
 
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filepath));
 
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();
 
			System.out.println(conn);
			conn.disconnect();
			logger.info("根据ticket换取二维码成功,文件路径:"+filepath);
		} catch (Exception e)
		{
			filepath = null;
			logger.info("根据ticket换取二维码失败" + e);
		}
 
		return filepath;
 
	}
	
	
	
	
	
	/**
	 * 实例
	 */
	public static void main(String[] args)
	{
		String assesstoken = WeixinUtil.getAccessToken();
 
		String ticket = createForeverTicket(assesstoken, 617);
		String path = "d:/QRcode";
		getRQcode(ticket, path);
 
	}
}
