package com.maa_portfolio.library_site.model;

public class Book {
		
	private String name;
	private String author;
	private int isbn;
	private int qty;
	
	//Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	//Getters
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public int getQty() {
		return qty;
	}
}
