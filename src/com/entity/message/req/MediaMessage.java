package com.entity.message.req;

/**
 * @desc 用户对公众号发送的视频及小视频的类型消息
 * @author Leon
 *
 */
public class MediaMessage extends BaseMessage{

	//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String MediaId;//
	
	//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	private String ThumbMediaId;//

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
	
}
