package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
	
	@GetMapping("/search")
	public String search()
	{
		System.out.println("Insearch Controller");
		return "search";
	}

}
