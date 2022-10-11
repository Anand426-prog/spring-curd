package com.ananda.dba;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ananda.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	

}

