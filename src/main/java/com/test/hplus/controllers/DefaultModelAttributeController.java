package com.test.hplus.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;

@ControllerAdvice
public class DefaultModelAttributeController {
	
	// This method return default values to model attribute in Registration
		// Controller when user not entered anything
		@ModelAttribute("newuser")
		public User getDefaultUser() {
			return new User();
		}

		@ModelAttribute("genderItems")
		public List<String> getGenderItems() {
			return Arrays.asList(new String[] { "Male", "Female", "Other" });
		}
		
		@ModelAttribute("login")
		public Login getDefaultogin() {
			return new Login();
		}

}
