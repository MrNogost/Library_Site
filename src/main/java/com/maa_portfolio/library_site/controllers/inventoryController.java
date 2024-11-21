package com.maa_portfolio.library_site.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maa_portfolio.library_site.services.InventoryService;
import com.maa_portfolio.library_site.model.Book;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inventoryController {
		
	private final InventoryService inventoryService;
	
	inventoryController(InventoryService inventoryService){
		this.inventoryService = inventoryService;
	}
	
	@GetMapping("/viewAll")
	public String viewAll(Model model) {
		
		List<Book> books = inventoryService.retrieveAll();
		model.addAttribute("books",books);
		return "view-all.html";
	}
		
	@GetMapping("/addBook")
	public String addBook() {
		return "addBook.html";
	}
	
	@PostMapping("/addBookConfirmation")
	public String addBookConfirmation(
			@RequestParam String name,
			@RequestParam String author,
			@RequestParam int isbn,
			@RequestParam int qty,
			Model model) {
		boolean success =inventoryService.addBook(name, author, isbn, qty);
		model.addAttribute("success",success);
		model.addAttribute("bookName",name);
		return "addBookConfirmation.html";
	}
}
