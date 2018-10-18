package com.entity.message.rsp;

/**
 * @desc 消息基类（公众账号 -> 普通用户）
 * @author Leon Lan
 *
 */
public class BaseMessage {
	// 普通用户、接收方账号（收到的openid）
	private String ToUserName;
	
	// 公众账号、开发者微信号
	private String FromUserName;
	
	// 消息创建时间 （整型）
	private long CreateTime;
	
	// 消息类型（text/image/location/link）
	private String MsgType;
	
	////
	private int FuncFlag;
	
	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}


}
