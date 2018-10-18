package com.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文素材集合类
 * @author Ruby
 *
 */
public class ArticlesList {
	//图文集合
	private List<NewsResource> articles = new ArrayList();
	public List<NewsResource> getArticles() {
		return articles;
	}

	public void setArticles(List<NewsResource> articles) {
		this.articles = articles;
	}
	
	
}
