package com.test.hplus.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		System.out.println("Ending User Session");
		session.invalidate();
		return "login";
	}

}
