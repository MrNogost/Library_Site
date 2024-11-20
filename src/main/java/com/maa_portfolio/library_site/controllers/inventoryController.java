package com.maa_portfolio.library_site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inventoryController {
		
		@GetMapping("/viewAll")
		public String viewAll(Model model) {
			
			return "view-all.html";
		}
		
		
}
