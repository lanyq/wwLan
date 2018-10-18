package com.entity.message.rsp;
/**
 * @desc 开发者对用户回复的语音消息类型
 * @author LAN
 *
 */
public class VoiceMessage extends BaseMessage{

	
	//通过素材管理中的接口上传多媒体文件，得到的id
	
	private String MediaId;//

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
