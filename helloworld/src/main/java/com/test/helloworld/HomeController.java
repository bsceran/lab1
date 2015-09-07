package com.test.helloworld;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.helloworld.entity.Account;
import com.test.helloworld.entity.ArticleContent;
import com.test.helloworld.services.ArticleServiceFacade;
import com.test.persist.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private UserDetailsManager userDetailsManager;
	
	@Autowired
	private ArticleServiceFacade articleService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}. ", request.getRequestURL().toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
//		model.addAttribute("theMessage", messageBean.getMessage());

		return "index";
	}

	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("userDetails", getUserDetails(request));
		return "header";
	}
	
	private UserDetails getUserDetails(HttpServletRequest request) {
		if(request.getUserPrincipal() != null) {
			String username = request.getUserPrincipal().getName();
			return userDetailsManager.loadUserByUsername(username);
		}
		return null;
	}

	@RequestMapping(value = "footer", method = RequestMethod.GET)
	public String footer(ModelMap modelMap) {
		return "footer";
	}

	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage(ModelMap modelMap) {
		modelMap.put("account", new Account());
		return "register2";
	}

	// @RequestMapping(value = "/registerRequest", method = RequestMethod.POST)
	// public String registerComplete(@ModelAttribute(value="account") Account
	// account, ModelMap modelMap) {
	// modelMap.put("registeredAccount", account);
	//
	//
	// return "redirect:index.html";
	// }

	@RequestMapping(value = "/registerRequest", method = RequestMethod.POST)
	public String add(@ModelAttribute(value = "account") Account account, ModelMap modelMap) {
		if (account != null) {
			User user = new User(account.getUsername(), account.getPassword(), "ROLE_USER");
			userDetailsManager.createUser(user);
		}

		return "redirect:index.html";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request) {

		// ModelAndView model = new ModelAndView();
		// model.addObject("title", "Spring Security Hello World");
		// model.addObject("message", "This is protected page!");
		// model.addObject("userName", request.getUserPrincipal().getName());
		// model.setViewName("index.html");
		return "redirect:index.html";
		// return model;

	}
	
	@RequestMapping(value = "/admin/displayAddArticlePage", method = RequestMethod.GET)
	public String displayAddArticlePage(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("articleContent", new ArticleContent());
		modelMap.put("contextPath", request.getContextPath());
		return "add_article";
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

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.addObject("contextPath", request.getContextPath());
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		model.addObject("account", new Account());
		model.addObject("contextPath", request.getContextPath());
		model.setViewName("register2");

		return model;

	}
}
