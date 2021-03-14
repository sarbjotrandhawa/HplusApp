package com.test.hplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.exceptions.ApplicationException;
import com.test.hplus.repository.UserRepository;

@Controller
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
    private UserRepository userRepository;
	
	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login)
	{
		System.out.println("In home controller");
		 User user  = userRepository.searchByName(login.getUsername());
	        if(user==null){
	            throw new ApplicationException("User not found");
	        }
	        
	        return "forward:/userprofile";
	}
	

}
