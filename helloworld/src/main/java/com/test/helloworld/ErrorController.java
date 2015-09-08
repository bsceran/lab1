package com.test.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/error")
public class ErrorController {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String page403() {
		return "redirect:/index.html";
	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String page404() {
//		 String origialUri = (String) request.getAttribute(
//                 RequestDispatcher.FORWARD_REQUEST_URI); OR
//				   "javax.servlet.error.request_uri");	
		
		return "redirect:/index.html";
	}

}
