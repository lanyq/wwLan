package com.entity.message.req;
/**
 * @desc 用户对公众号发送的文字消息类型
 * @author LAN
 *
 */
public class TextMessage extends BaseMessage{
    //
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	
}
