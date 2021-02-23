package com.test.hplus.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.hplus.beans.User;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome() {
		System.out.println("In Home return index");
		return "index";
	}

	@GetMapping("/goToSearch")
	public String goToSearch() {
		System.out.println("In home return search");
		return "search";
	}

	@GetMapping("/goToLogin")
	public String goToLogin() {
		System.out.println("In Home return login");
		return "login";
	}

	@GetMapping("/goToRegistration")
	public String goToRegistration() {
		System.out.println("In Home return Registration");
		return "register";
	}

	// This method return default values to model attribute in Registration
	// Controller when user not entered anything
	@ModelAttribute("newuser")
	public User getDefaultUser() {
		return new User();
	}
	
	@ModelAttribute("genderItems")
	public List<String> getGenderItems()
	{
		return Arrays.asList(new String[] {"Male","Female","Others"});
	}
}
