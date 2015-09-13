package com.test.helloworld.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles7")
public class ArticleContent {

	@Id
    private ObjectId _id;
	
	private String content="";
	private String publishedContent="";
	private boolean publishable=false;

	public ObjectId get_id() {
		return _id;
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id;
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
	
	public void setPublishedContent(String publishedContent) {
		this.publishedContent = publishedContent;
	}
	
	public String getPublishedContent() {
		return publishedContent;
	}
}
