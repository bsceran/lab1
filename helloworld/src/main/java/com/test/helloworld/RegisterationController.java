package com.test.helloworld;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.helloworld.entity.Account;
import com.test.helloworld.entity.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegisterationController {

	@Autowired
	private UserDetailsManager userDetailsManager;

	@RequestMapping(value = "/registerRequest", method = RequestMethod.POST)
	public String add(@ModelAttribute(value = "account") Account account, ModelMap modelMap) {
		if (account != null) {
			User user = new User(account.getUsername(), account.getPassword(), "ROLE_USER");
			userDetailsManager.createUser(user);
		}

		return "redirect:index.html";
	}

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
