package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String getindexPage() {
		return "index";

	}

	
	@RequestMapping("/home")
	public ModelAndView showHomePage() {
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("msg", "Welcome to  My Home Page");
		return mv;
	}

	@RequestMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}

}
