package com.dataexport.pdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataexport.pdf.model.Book;
import com.dataexport.pdf.repo.DataRepository;

@Service
public class DataServiceImpl implements IDataService{

	@Autowired
	private DataRepository dataRepository;
	@Override
	public List<Book> getAllBook() {
		
		return dataRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		 return dataRepository.getById(id);
	}

	@Override
	public void saveBook(Book book) {
		dataRepository.save(book);
		
	}

	@Override
	public void deleteBookById(Integer id) {
		dataRepository.deleteById(id);
	}

}
