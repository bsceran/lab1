package com.test.helloworld.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.test.helloworld.entity.ArticleContent;

public interface ArticleServiceFacade {

	void saveArticle(ArticleContent articleContent);

	List<ArticleContent> getAllArticles();

	List<ArticleContent> getPublishedArticles();

	void deleteArticle(ObjectId articleId);

	ArticleContent findArticle(ObjectId articleId);

	void saveAndPublishArticle(ArticleContent content);
}
