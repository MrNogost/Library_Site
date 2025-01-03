package com.maa_portfolio.library_site.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.maa_portfolio.library_site.model.Book;

@Repository
public class MainRepository {
	
	private JdbcTemplate jdbc;
	
	public MainRepository(JdbcTemplate jdbc){
		this.jdbc = jdbc;
	}
	
	public List<Book> retrieveAll(){
		String sql = "SELECT * FROM inventory";
		
		RowMapper<Book> inventoryRowMapper = (r,i) ->{
			Book rowObject = new Book();
			rowObject.setName(r.getString("name"));
			rowObject.setAuthor(r.getString("author"));
			rowObject.setIsbn(r.getInt("isbn"));
			rowObject.setQty(r.getInt("qty"));
			return rowObject;
		};
		
		return jdbc.query(sql, inventoryRowMapper);
	}
	
	public boolean addBook(Book book) {
		String sql = "INSERT INTO inventory VALUES (?,?,?,?)";
		
		int value = jdbc.update(sql,
				book.getName(),
				book.getAuthor(),
				book.getIsbn(),
				book.getQty());
		
		if(value == 1) return true;
		else return false;
	}
	
	public boolean updateBook(Book book) {
		String verifyQuery = "SELECT COUNT(*) FROM inventory WHERE isbn = ?";
		int count = jdbc.queryForObject(verifyQuery, Integer.class, book.getIsbn());
		
		if(count > 0) {
			String updateQuery = "UPDATE inventory SET name = ?, author = ?, qty = ? WHERE isbn = ?";;
            int rowsAffected = jdbc.update(updateQuery, book.getName(), book.getAuthor(), book.getQty(),  book.getIsbn());
            return rowsAffected > 0;
		}
		else return false;
	}
	public boolean deleteBook(Book book) {
		String verifyQuery = "SELECT COUNT(*) FROM inventory WHERE isbn = ? AND name = ? AND author = ?";
		int count = jdbc.queryForObject(verifyQuery, Integer.class, book.getIsbn(), book.getName(), book.getAuthor());
		
		if(count > 0) {
			String deleteQuery = "DELETE FROM inventory WHERE isbn = ?";
            int rowsAffected = jdbc.update(deleteQuery, book.getIsbn());
            return rowsAffected > 0;
		}
		else return false;
	}
}
