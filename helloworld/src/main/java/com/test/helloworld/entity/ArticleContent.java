package com.test.helloworld.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles")
public class ArticleContent {

	@Id
	private String id;
	private String content;
	private boolean publishable;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPublishable(boolean publishable) {
		this.publishable = publishable;
	}
	 
	public boolean isPublishable() {
		return publishable;
	}
}
