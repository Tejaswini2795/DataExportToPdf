package com.dataexport.pdf.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataexport.pdf.model.Book;
import com.dataexport.pdf.service.FileExporter;
import com.dataexport.pdf.service.IDataService;

@RestController
@RequestMapping("/book")
public class DataExportController {
	@Autowired
	private IDataService dataService;
	
	@Autowired
	private FileExporter fileExporter;
	
	@GetMapping("/getallbooks")
	public List<Book> GetAllBook(){
		return dataService.getAllBook();
	}
	
	@PostMapping("/save")
	public void saveBook(@RequestBody Book book) {
		dataService.saveBook(book);
	}
	
	@GetMapping("/gePdfFile")
	public void GetPdfFile(HttpServletResponse response){
		try {
		 List<Book> listOfBook = dataService.getAllBook();
		 fileExporter.exportToPDF(listOfBook, response);
		}catch(Exception e) {
			response.getStatus();
		}
	}
	
	@DeleteMapping("/deleteBookById/{id}")
	public void deleteBookById(@RequestParam Integer bookId) {
		if(bookId != 0)
		dataService.deleteBookById(bookId);
		else
			System.out.println("not a valid input");
	}
	
	

}
