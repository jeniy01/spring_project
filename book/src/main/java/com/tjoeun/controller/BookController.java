package com.tjoeun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tjoeun.domain.Book;
import com.tjoeun.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String books(Model model) {
		List<Book> bookList = bookService.getAllBookList();
		System.out.println(bookList.size());
		model.addAttribute("bookList", bookList);
		return "books";
	}
	
	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		ModelAndView mv = new ModelAndView();
		List<Book> bookList = bookService.getAllBookList();
		mv.addObject("bookList", bookList);
		mv.setViewName("books");
		return mv;
	}
	
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String category, Model model) {
		List<Book> booksByCategory = bookService.getBookListByCategory(category);
		model.addAttribute("bookList", booksByCategory);
		return "books";
	}
}
