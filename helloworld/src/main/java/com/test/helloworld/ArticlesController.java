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
		modelMap.put("contextPath", request.getContextPath());
		return "manage_articles";
	}
	
	@RequestMapping(value = "/admin/addArticle", method = RequestMethod.POST)
	public String addArticlePage(@ModelAttribute(value = "articleContent") ArticleContent content, ModelMap modelMap) {
		articleService.addArticle(content);
		return "redirect:/index.html";
	}
	
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public String articles(ModelMap modelMap) {
		List<ArticleContent> articles = articleService.getAllArticles();
		modelMap.put("articles", articles);
		return "articles";
	}
}
