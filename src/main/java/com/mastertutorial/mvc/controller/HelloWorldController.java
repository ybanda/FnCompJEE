/**
 * 
 */
package com.mastertutorial.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mastertutorial.mvc.model.Product;
import com.mastertutorial.mvc.model.ProductService;

/**
 * @author Yashwanth
 *
 */
@Controller
public class HelloWorldController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value= {"/","/home"},method=RequestMethod.GET)
	public String homePage(ModelMap model) {
		System.out.println("HelloWorldController :: Home Page");
	
		model.addAttribute("welcome","Welcome to Home Page");
		return "welcome";

	}

	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user",getPrincipal());

		return 
				"admin";
	}
	@RequestMapping(value="/adminPost",method=RequestMethod.POST)
	public String adminPageGet(ModelMap model) {

		System.out.println("HelloWorldController :: adminPageGet Page");
        model.addAttribute("user", getPrincipal());
        System.out.println(productService.getAllProducts());
        System.out.println("cc Value Before ="+productService.getByName("cc").toString());
        Product product = new Product("cc",504);
        productService.updateProduct(product);
        System.out.println("cc Value After ="+productService.getByName("cc").toString());
        System.out.println(productService.getAllProducts());
        return "admin";
	}
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {

		System.out.println("HelloWorldController :: accessDeniedPage Page");
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	private String loginPage() {
		System.out.println("HelloWorldController :: loginPage Page");
		return "login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	private String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloWorldController :: logoutPage Page");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null)
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		
		return "redirect:/login?logout";
	}
	private String getPrincipal() {
		System.out.println("HelloWorldController :: getPrincipal Page");
		String userName=null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if(principal instanceof UserDetails)
			userName=((UserDetails)principal).getUsername();
		else
			userName=principal.toString();
		return userName;
	}
}
