package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dao.QrCodeDao;
import com.dao.QrCodeImpl;
import com.entity.QRRelateInfo;
import com.entity.QRcode;
import com.entity.message.rsp.TextMessage;
import com.util.MessageUtil;

/**
 * @DESC 核心服务类
 * @author Leon
 *
 */
public class WechatCoreService {
	private static  QrCodeDao qrDao=new QrCodeImpl();

	/**
	 * 处理用户发来微信消息后的回复
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request,QRRelateInfo qrInfo) {
		List<QRRelateInfo> list=new ArrayList<QRRelateInfo>();
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";
 
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
 
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
 
			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
 
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "您发送的是文本消息！";
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				
				String eventType = requestMap.get("Event");// 事件类型
				
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {// 订阅
					respContent = "Hi,感谢关注汉周文化公众号！";
					/**
					 * 分两种情况：@1：带eventKey的话则是带二维码扫描的关注事件
					 * @2：不带eventkey的话则是不带二维码扫描的关注事件
					 */
					if(requestMap.containsKey("EventKey")){//EventKey为事件KEY值，qrscene_为前缀，后面为二维码的参数值
						String EventKey=requestMap.get("EventKey");//获取扫描带参数二维码
						String Ticket=requestMap.get("Ticket");//二维码的ticket，可用来换取二维码图片
						//根据事件值获取视频二维码信息，并返回链接
						qrInfo=qrDao.getQrCodeInfo(EventKey);
						respContent+=qrInfo.getVideo();
					}
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
				}
			}
 
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return respMessage;
	}
	
	
}
