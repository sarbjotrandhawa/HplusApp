package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome() {
		System.out.println("In Home Controller");
		return "index";
	}
	
	@GetMapping("/goToSearch")
	public String goToSearch() {
		System.out.println("In Home Controller");
		return "search";
	}
}
