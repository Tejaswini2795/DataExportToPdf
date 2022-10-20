package com.dataexport.pdf.service;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.dataexport.pdf.model.Book;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class FileExporter {
	
	public void setResponseHeader(HttpServletResponse response, String contentType, String extension, String prefix)
			throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String timeStamp = dateFormat.format(new Date());
		String fileName = prefix + timeStamp + extension;

		response.setContentType(contentType);

		String headerKey = "Content.Disposition";
		String headerValue = "attachment; filename=" + fileName;
		response.setHeader(headerKey, headerValue);
	}
	
	public void exportToPDF(List<Book> listOfBook, HttpServletResponse response)throws  IOException{
		setResponseHeader(response, "application/pdf", ".pdf", "book_");
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.black);
		
		Paragraph para = new Paragraph("List of book", font);
		para.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(para);
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(10);
		writeBookHeader(table);
		writeBookData(table, listOfBook);
		
		document.add(table);
		document.close();
		
	}
	
	private void writeBookData(PdfPTable table, List<Book>listOfBook) {
		for(Book book : listOfBook) {
			table.addCell(String.valueOf(book.getId()));
			table.addCell(book.getBookName());
			table.addCell(book.getAuthorName());
		}
	}
	
	private void writeBookHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.orange);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.white);
		
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Book Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Author Name", font));
		table.addCell(cell);
		
	}

}
