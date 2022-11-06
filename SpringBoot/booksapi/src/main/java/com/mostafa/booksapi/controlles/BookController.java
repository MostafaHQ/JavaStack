package com.mostafa.booksapi.controlles;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mostafa.booksapi.models.Book;
import com.mostafa.booksapi.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}

}
