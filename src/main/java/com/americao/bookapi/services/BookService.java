package com.americao.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.americao.bookapi.models.Book;
import com.americao.bookapi.repositories.BookRepository;

@Service
public class BookService {
 // adding the book repository as a dependency
	private final BookRepository bookRepository;
 
	public BookService(BookRepository bookRepository){
     this.bookRepository = bookRepository;
 }
 // returns all the books
	public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
	public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
	public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	    Book changeBook = this.findBook(id);
	    changeBook.setTitle(title);
	    changeBook.setDescription(desc);
	    changeBook.setLanguage(lang);
	    changeBook.setNumberOfPages(numOfPages);
	    return bookRepository.save(changeBook);
	}


	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}

}

