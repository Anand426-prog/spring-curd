package com.ananda.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ananda.dba.BookRepository;
import com.ananda.exception.BookNotFoundException;
import com.ananda.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository repo;

	@PostMapping("/addbook")
	public Book createBook(@Valid @RequestBody Book book) {

		return repo.save(book);
	}

	@GetMapping("/")
	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {

		Optional<Book> findById = repo.findById(id);

		if (findById.isPresent()) {
			return findById.get();
		} else
			throw new BookNotFoundException("id" + id);
	}

	@DeleteMapping("/{id}")

	public void deleteBook(@PathVariable Long id) {

		Optional<Book> findById = repo.findById(id);

		if (findById.isPresent()) {
			repo.deleteById(id);
		} else {
			throw new BookNotFoundException("Book not present for this " + id);
		}

	}

}
