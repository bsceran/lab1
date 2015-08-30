package com.test.helloworld;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.commons.MessageBean;
import com.test.helloworld.entity.Account;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private MessageBean messageBean;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}. ", request.getRequestURL().toString());
		
		String url = request.getRequestURL().toString();
		if(isIndexPage(url)) {
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate);
			model.addAttribute("theMessage", messageBean.getMessage());
			
			return "index";
		} else {
			return getViewName(url);
		}
	}
	
	private boolean isIndexPage(String url) {
		if(url.endsWith(".html") && !url.contains("index.html")) {
			return false;
		} else {
			return true;
		}
	}
	
	private String getViewName(String url) {
		int lastIndexOfHTML = url.lastIndexOf("/");
		int f = url.lastIndexOf(".html");
		return url.substring(lastIndexOfHTML + 1, f);
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String registerRequest(ModelMap modelMap) {
		modelMap.put("account", new Account());
		return "register";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerComplete(@ModelAttribute(value="account") Account account, ModelMap modelMap) {
		modelMap.put("registeredAccount", account);
		return "registerSuccess";
	}
}
