package com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import manager.JEEWeiXinX509TrustManager;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.constant.WeixinConstants;
import com.entity.Token;
/**
 * @desc 公众平台通用接口工具类
 * @author Leon
 *
 */
public class WeixinUtil {
	   private static Logger logger=Logger.getLogger(WeixinUtil.class);
	   //从微信后台拿到APPID和APPSECRET 并封装为常量
	    private static final String APPID = "wxe4f4d28e266b2da0";
	    private static final String APPSECRET = "a2b1e8f703a2627fea4b9c74ff97d846";
	    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	   
	   
	   /** 
	        * 发起https请求并获取结果 
	        *  
	        * @param requestUrl 请求地址 
	        * @param requestMethod 请求方式（GET、POST） 
	        * @param outputStr 提交的数据 
	        * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
	        */
	   public static JSONObject httpRequest(String requestUrl,String requestMethod,String outputStr){
		   JSONObject jsonObject = null; 
		   StringBuffer buffer = new StringBuffer();  
		   try {  
			   TrustManager[] tm = { new JEEWeiXinX509TrustManager() };
			   SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE"); 
			   sslContext.init(null, tm, new java.security.SecureRandom());  
			   SSLSocketFactory ssf = sslContext.getSocketFactory();
			   URL url = new URL(requestUrl);
			   HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			   httpUrlConn.setSSLSocketFactory(ssf);
			   httpUrlConn.setDoOutput(true); 
			   httpUrlConn.setDoInput(true);  
	           httpUrlConn.setUseCaches(false); 
	           httpUrlConn.setRequestMethod(requestMethod); 
	           if ("GET".equalsIgnoreCase(requestMethod))  
	                httpUrlConn.connect(); 
	           // 当有数据需要提交时  
	       	if (null != outputStr) {
	              OutputStream outputStream = httpUrlConn.getOutputStream();
	       	      outputStream.write(outputStr.getBytes("UTF-8"));
	       	      outputStream.close();
	       	      }
	        InputStream inputStream = httpUrlConn.getInputStream();  
	        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
	        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	        String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
		   }catch(ConnectException e){
			   logger.error("Weixin server connection timed out."); 
		   }catch (Exception ex) {  
	            logger.error("https request error:{}", ex);  
	        } 
		   return jsonObject;
	   }
	   
	   /**
	    * 对ticket进行转码，utf-8
	    * @param ticket
	    * @return
	 * @throws Exception 
	    */
	   public static String urlencodeutf8(String ticket) throws Exception{
			String retrunStr=URLEncoder.encode(ticket,"utf-8");
			return retrunStr;
		}
	   
	   
	   /**
	   *获取令牌access_token
	   */
	       public static String getAccessToken() {
	           String APP_ID = WeixinConstants.APPID;//微信id
	           String APP_SECRET=WeixinConstants.APPSECRET;//微信秘钥
	           //微信令牌请求网址(由微信提供)
	           String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRET;
	           String accessToken = null;
	           try {
	               URL urlGet = new URL(url);
	               HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
	               http.setRequestMethod("GET"); // 必须是get方式请求
	               http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	               System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
	               System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
	               http.connect();
	               InputStream is = http.getInputStream();
	               int size = is.available();
	               byte[] jsonBytes = new byte[size];
	               is.read(jsonBytes);
	               String message = new String(jsonBytes, "UTF-8");
	               logger.info("调用getAccessToken接口成功,获取token返回信息:"+message);
	               JSONObject demoJson = new JSONObject(message);
	               accessToken = demoJson.getString("access_token");
	               is.close();
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	           return accessToken;
	       }
	       public static Token getAccessToken(String appid,String appsecret){
	    	   String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret;
	           String accessToken = null;
	           Token token=new Token();
	           try {
	               URL urlGet = new URL(url);
	               HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
	               http.setRequestMethod("GET"); // 必须是get方式请求
	               http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	               System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
	               System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
	               http.connect();
	               InputStream is = http.getInputStream();
	               int size = is.available();
	               byte[] jsonBytes = new byte[size];
	               is.read(jsonBytes);
	               String message = new String(jsonBytes, "UTF-8");
	               logger.info("调用getAccessToken接口成功,获取token返回信息:"+message);
	               JSONObject demoJson =new JSONObject(message);
	               accessToken = demoJson.getString("access_token");
	               token.setAccessToken(accessToken);
	               int expires_in=demoJson.getInt("expires_in");
	               token.setExpiresIn(expires_in);
	               is.close();
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	           return token;
	       }
}
