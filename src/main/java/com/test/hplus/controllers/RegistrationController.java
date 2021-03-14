package com.test.hplus.controllers;


import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class RegistrationController {
	@Autowired
	UserRepository userRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		//true I used, as it can take empty values as well
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(new SimpleDateFormat("YYYY-MM-dd"),true));
	}
	
	/* @Valid is used for checking the errors from the annotations defined in model components.
	 * If there is any error then we same to send the response back with a particular message.
	 * BindingResult helps us to send back error messages to client and map all the error messages
	 *  to a client side in a form.*/
	
	@PostMapping("/registerUser")
	public String  registerUser(@Valid @ModelAttribute("newuser")User user,BindingResult result, Model model)
	{
		System.out.println(user.getDateOfBirth());
		System.out.println(user.getPassword());
		System.out.println("Gender"+ user.getGender().toString());
		
		if(result.hasErrors())
		{
			return "register";
		}
		
		System.out.println(user.getDateOfBirth());
		
		userRepository.save(user);
		
		model.addAttribute("saveddata", "User Registered Sucessfully!!");
		return "login";
	}

}
