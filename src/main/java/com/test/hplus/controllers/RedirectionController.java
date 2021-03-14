package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {
	
	@GetMapping("/redirectToLinkedIn")
	public String redirect()
	{
		System.out.println("In redirect Controller ");
		return "redirect:https://www.linkedin.com";
	}

}
