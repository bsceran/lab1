package com.test.helloworld.services;

import java.util.List;

import com.test.helloworld.entity.ArticleContent;

public interface ArticleServiceFacade {

	void saveArticle(String articleId, ArticleContent articleContent);

	List<ArticleContent> getAllArticles();

	List<ArticleContent> getPublishedArticles();

	void deleteArticle(String articleId);

	ArticleContent findArticle(String articleId);

	void saveAndPublishArticle(String articleId, ArticleContent content);

	void publishArticle(String articleId, boolean publish);
}
