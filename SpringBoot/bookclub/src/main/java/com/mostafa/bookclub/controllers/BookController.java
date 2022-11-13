package com.mostafa.bookclub.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mostafa.bookclub.models.Book;
import com.mostafa.bookclub.models.User;
import com.mostafa.bookclub.services.BookService;
import com.mostafa.bookclub.services.UserService;

@Controller
public class BookController {
	
	private final BookService bookService;
	private final UserService userService;

	public BookController(BookService bookService, UserService userService) {
		this.bookService = bookService;
		this.userService = userService;
	}
	
	@GetMapping("/books")
	public String index(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		model.addAttribute("books", bookService.allBooks());
		return "books.jsp";
	}
	
	@GetMapping("/books/new")
	public String creat(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User currentUser = userService.findUserById(userId);
		model.addAttribute("currentUser", currentUser);	
		return "new.jsp";
	}
	
	@PostMapping("/books/new")
	public String creatBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "new.jsp";
		}else {
			bookService.creatBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("book", bookService.findBook(id));
		return "show.jsp";
	}
	
}


