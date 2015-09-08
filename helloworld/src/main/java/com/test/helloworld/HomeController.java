package com.test.helloworld;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header(ModelMap modelMap, HttpServletRequest request) {
		return "header";
	}

	@RequestMapping(value = "/footer", method = RequestMethod.GET)
	public String footer(ModelMap modelMap) {
		return "footer";
	}
}
