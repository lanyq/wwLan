package com.entity.message.rsp;
/**
 * @desc 开发者对用户回复的视频消息类型
 * @author LAN
 *
 */
public class MediaMessage extends BaseMessage{

	
	//通过素材管理中的接口上传多媒体文件，得到的id
	private String MediaId;//
	
	//视频消息的标题
	private String Title;//
	
	//视频消息的描述
	private String Description;//
}
