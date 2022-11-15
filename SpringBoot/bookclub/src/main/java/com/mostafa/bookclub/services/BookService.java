package com.mostafa.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mostafa.bookclub.models.Book;
import com.mostafa.bookclub.models.User;
import com.mostafa.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository  bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
		}
	
	public Book creatBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	public List<Book> unborrowedBooks(User user){
		return bookRepository.findByBorrowerIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Book> borrowedBooks(User user){
		return bookRepository.findByBorrowerIdIs(user.getId());
	}
	
	public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepository.save(book);
	}
	
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepository.save(book);
	}
	
	public List<Book> myBooks(User user){
		return bookRepository.findByUserIdIs(user.getId());
	}
}
