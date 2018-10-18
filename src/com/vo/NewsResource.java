package com.vo;

/**
 * 图文素材
 * 
 * 提供新增永久素材接口使用
 * @author Ruby
 *
 */
public class NewsResource {
	//标题
	private String title;
	//图片素材ID
	private String thumb_media_id;
	//作者
	private String author;
	//摘要
	private String digest;
	//是否显示封面
	private int show_cover_pic;
	//原文
	private String content;
	//原地址
	private String content_source_url;
	public String getContent_source_url() {
		return content_source_url;
	}
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public int getShow_cover_pic() {
		return show_cover_pic;
	}
	public void setShow_cover_pic(int show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
