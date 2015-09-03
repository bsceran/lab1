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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping(value = {"/","/index.html"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}. ", request.getRequestURL().toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("theMessage", messageBean.getMessage());
		
		return "index";
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header(ModelMap modelMap) {
		return "header";
	}
	
	@RequestMapping(value = "footer", method = RequestMethod.GET)
	public String footer(ModelMap modelMap) {
		return "footer";
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
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request) {

//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page!");
//		model.addObject("userName", request.getUserPrincipal().getName());
//		model.setViewName("index.html");
		return "redirect:index.html";
//		return model;

	}
	
	//Spring Security see this :
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request) {

			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}

			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.addObject("contextPath",request.getContextPath());
			model.setViewName("login");

			return model;

		}
}
