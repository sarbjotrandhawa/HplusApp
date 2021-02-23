package com.test.hplus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;

@Controller
public class SearchController {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/search")
	public String search(@RequestParam("search") String search, Model model)
	{
		System.out.println("Insearch Controller");
		
		List<Product> products = productRepository.searchByName(search);
		if(products!=null)
		{
			System.out.println(products.toString());
		}
		model.addAttribute("products",products);
		
		return "search";
	}

}
