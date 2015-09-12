package com.test.helloworld.services;

import java.util.List;

import com.test.helloworld.entity.ArticleContent;

public interface ArticleServiceFacade {

	void saveArticle(ArticleContent articleContent);

	List<ArticleContent> getAllArticles();

	List<ArticleContent> getPublishedArticles();
}
