package com.test.helloworld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.test.helloworld.entity.ArticleContent;

@Service
public class ArticleService implements ArticleServiceFacade{

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void saveArticle(ArticleContent articleContent) {
		mongoOperations.save(articleContent);
	}

	@Override
	public List<ArticleContent> getAllArticles() {
		return mongoOperations.findAll(ArticleContent.class);
	}

	@Override
	public List<ArticleContent> getPublishedArticles() {
		Query query = new Query(Criteria.where("publishable").is(true));
		return mongoOperations.find(query, ArticleContent.class);
	}

	@Override
	public void deleteArticle(String articleId) {
		Query query = new Query(Criteria.where("id").is(articleId));
		mongoOperations.remove(query, ArticleContent.class);
	}

	@Override
	public ArticleContent findArticle(String articleId) {
		return mongoOperations.findById(articleId, ArticleContent.class);
	}
}
