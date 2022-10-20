package com.dataexport.pdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dataexport.pdf.rest.DataExportController;

@SpringBootApplication
public class ExportDataInFilesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ExportDataInFilesApplication.class, args);
		 context.getBean(DataExportController.class);
		
	}

}
