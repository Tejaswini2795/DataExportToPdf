package com.dataexport.pdf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataexport.pdf.model.Book;
@Repository
public interface DataRepository extends JpaRepository<Book, Integer>{

}
