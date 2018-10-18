package com.entity.message.rsp;
/**
 * @desc 开发者回复用户的图片类
 * @author LAN
 *
 */
public class ImageMessage extends BaseMessage{

	//通过素材管理中的接口上传多媒体文件，得到的id。
	 private String MediaId;//

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	 
}
