package com.mostafa.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mostafa.bookclub.models.Book;
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
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return"redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("currentUser", userService.findUserById(userId));
		model.addAttribute("books", bookService.allBooks());
		return "books.jsp";
	}

	
	@GetMapping("/books/new")
	public String creat(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
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
		if(session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		model.addAttribute("book", bookService.findBook(id));
		return "show.jsp";
	}

	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("book", bookService.findBook(id));
		return "edit.jsp";	
	}
	
	@PutMapping("/books/{id}/edit")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "new.jsp";
		}else {
			bookService.updateBook(book);
			return "redirect:/books/"+id;
		}
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
    	}
    	Book book = bookService.findBook(id);
    	if(session.getAttribute("userId") == book.getUser().getId()) {
    	bookService.deleteBook(id);
    	}
    	return "redirect:/books";
	}
	
	@GetMapping("/bookmarket")
	public String market(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return"redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("currentUser", userService.findUserById(userId));
		model.addAttribute("book",bookService.unborrowedBooks(userService.findUserById(userId)));
		model.addAttribute("myBooks", bookService.borrowedBooks(userService.findUserById(userId)));
		return "bookmarket.jsp";
	}
	
	@RequestMapping("/bookmarket/{bookID}")
	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		bookService.addBorrower(bookService.findBook(bookID), userService.findUserById(userId));
		 
		return "redirect:/bookmarket";
	}
	
	@RequestMapping("/bookmarket/return/{bookID}")
	public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		bookService.removeBorrower(bookService.findBook(bookID));
		 
		return "redirect:/bookmarket";
	}
	
	
}


