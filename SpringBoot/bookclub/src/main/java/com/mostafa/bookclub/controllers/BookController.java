package com.mostafa.bookclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mostafa.bookclub.models.Book;
import com.mostafa.bookclub.services.BookService;

@Controller
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String index(@ModelAttribute("book") Book book, Model model) {
		model.addAttribute("books", bookService.allBooks());
		return "books.jsp";
	}
	
	
}


