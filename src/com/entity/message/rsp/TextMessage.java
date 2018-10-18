package com.entity.message.rsp;

/**
 * @desc 开发者回复用户的消息类
 * @author LAN
 *
 */
public class TextMessage extends BaseMessage{
    //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	
}
