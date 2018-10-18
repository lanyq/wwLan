package com.entity.message.rsp;

/**
 * @desc 开发者回复用户的音乐类型消息
 * @author LAN
 *
 */
public class MusicMessage extends BaseMessage{

	//音乐
	private Music music;//
	
	
	//Title音乐标题
	
	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
	
}
