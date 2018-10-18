package com.entity.message.rsp;

import java.util.List;

/**@Desc 开发者对用户回复的图文消息类型
 * @author LAN
 *
 */
public class NewsMessage {

	
	//图文消息个数，限制为1条以内
	private String ArticleCount;//
	
	//图文消息信息，注意，如果图文数超过1，则将只发第1条
	private List<Article> Articles;//
	
	

	public String getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}



	
}
