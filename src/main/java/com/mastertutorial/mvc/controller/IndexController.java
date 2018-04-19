package com.mastertutorial.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mastertutorial.mvc.core.SetterInjectionBeanImpl;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	SetterInjectionBeanImpl testBean;
	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage(Model model) {
		  model.addAttribute("Bean", testBean.getMessage());
	        return "index";
	    }

}