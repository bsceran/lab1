package com.test.helloworld.services;

import java.util.List;

import org.bson.types.ObjectId;
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
		ArticleContent findArticle = findArticle(articleContent.get_id());
		if(findArticle == null) {
			mongoOperations.save(articleContent);
		} else {
			findArticle.setContent(articleContent.getContent());
			mongoOperations.save(findArticle);
		}
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
	public void deleteArticle(ObjectId articleId) {
		Query query = new Query(Criteria.where("_id").is(articleId));
		mongoOperations.remove(query, ArticleContent.class);
	}

	@Override
	public ArticleContent findArticle(ObjectId articleId) {
		return mongoOperations.findById(articleId, ArticleContent.class);
	}

	@Override
	public void saveAndPublishArticle(ArticleContent articleContent) {
		ArticleContent findArticle = findArticle(articleContent.get_id());
		if(findArticle == null) {
			articleContent.setPublishable(true);
			articleContent.setPublishedContent(articleContent.getContent());
			mongoOperations.save(articleContent);
		} else {
			findArticle.setPublishable(true);
			findArticle.setPublishedContent(articleContent.getContent());
			findArticle.setContent(articleContent.getContent());
			mongoOperations.save(findArticle);
		}
	}
}
