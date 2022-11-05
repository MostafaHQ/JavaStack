package com.mostafa.booksapi.controlles;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
