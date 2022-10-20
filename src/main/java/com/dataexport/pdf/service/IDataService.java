package com.dataexport.pdf.service;

import java.util.List;

import com.dataexport.pdf.model.Book;

public interface IDataService {
	public List<Book> getAllBook();
	
	public Book getBookById(Integer id);
	
	public void saveBook(Book book);
	
	public void deleteBookById(Integer BookId);

}
