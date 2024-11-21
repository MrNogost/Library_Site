package com.maa_portfolio.library_site.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maa_portfolio.library_site.repositories.MainRepository;
import com.maa_portfolio.library_site.model.Book;

@Service
public class InventoryService {
	
	private final MainRepository mainRepository;
	
	InventoryService(MainRepository mainRepository){
		this.mainRepository = mainRepository;
	}
	
	public List<Book> retrieveAll(){
		return mainRepository.retrieveAll();
	}
	
	public boolean addBook(String name, String author, int isbn, int qty) {
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setIsbn(isbn);
		book.setQty(qty);
		boolean state = mainRepository.addBook(book);
		return state;
	}
}
