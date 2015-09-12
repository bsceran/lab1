package com.test.helloworld;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.helloworld.entity.ArticleContent;
import com.test.helloworld.services.ArticleServiceFacade;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ArticlesController {

	@Autowired
	private ArticleServiceFacade articleService;
	
	@RequestMapping(value = "/admin/displayAddArticlePage", method = RequestMethod.GET)
	public String displayAddArticlePage(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("articleContent", new ArticleContent());
		return "manage_articles";
	}
	
	@RequestMapping(params="save", value = "/admin/addArticle", method = RequestMethod.POST)
	public String saveTheArticle(@ModelAttribute(value = "articleContent") ArticleContent content, ModelMap modelMap) {
		articleService.saveArticle(content);
		modelMap.put("articleContent", new ArticleContent());
		return "manage_articles";
	}
	
	@RequestMapping(params="publish", value = "/admin/addArticle", method = RequestMethod.POST)
	public String saveAndPublishTheArticle(@ModelAttribute(value = "articleContent") ArticleContent content, ModelMap modelMap) {
		content.setPublishable(true);
		articleService.saveArticle(content);
		modelMap.put("articleContent", new ArticleContent());
		return "manage_articles";
	}
	
	@RequestMapping(value = "/publishedArticles")
	public String publishedArticles(ModelMap modelMap) {
		List<ArticleContent> articles = articleService.getPublishedArticles();
		modelMap.put("articles", articles);
		return "articles";
	}
	
	@RequestMapping(value = "/allArticles")
	public String allArticles(ModelMap modelMap) {
		List<ArticleContent> articles = articleService.getAllArticles();
		modelMap.put("articles", articles);
		return "articles";
	}
}
