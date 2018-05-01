/**
 * 
 */
package com.mastertutorial.mvc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Yashwanth
 *
 */
@Controller
public class HelloWorldController {

	@RequestMapping(value= {"/","/home"},method=RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("welcome","Welcome to Home Page");
		return "welcome";

	}

	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user",getPrincipal());

		return 
				"admin";
	}
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}
	private String getPrincipal() {

		String userName=null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if(principal instanceof UserDetails)
			userName=((UserDetails)principal).getUsername();
		else
			userName=principal.toString();
		return userName;
	}
}
