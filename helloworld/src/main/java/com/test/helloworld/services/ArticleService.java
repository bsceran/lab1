package com.test.helloworld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.test.helloworld.entity.ArticleContent;

@Service
public class ArticleService implements ArticleServiceFacade{

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void addArticle(ArticleContent articleContent) {
		mongoOperations.save(articleContent);
	}

	@Override
	public List<ArticleContent> getAllArticles() {
		return mongoOperations.findAll(ArticleContent.class);
	}
}
