package com.maa_portfolio.library_site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/inventory")
	public String inventory() {
		return "inventory.html";
	}
	
	@GetMapping("/borrow")
	public String borrow() {
		return "borrow.html";
	}
	
	@GetMapping("/return")
	public String returnB() {
		return "return.html";
	}
}
