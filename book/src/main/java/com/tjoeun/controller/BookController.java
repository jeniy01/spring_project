package com.tjoeun.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  	// System.out.println(bookList.size());
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
  public String requestBooksByCategory(@PathVariable("category") String category,
  		                                 Model model) {
  	List<Book> booksByCategory = bookService.getBookListByCategory(category);
  	model.addAttribute("bookList", booksByCategory);
  	return "books";
  }
  
  @GetMapping("/filter/{bookFilter}")
  // Map<String, List<String>> : 출판사별 책이름을 저장한 HashMap
  // @MatrixVariable 을 사용해서 지정한 출판사의 도서분야에 해당하는 도서 검색하기
  public String requestBooksByFilter(
  		@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter,
  		Model model) {
  	
  	Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
  	
  	model.addAttribute("bookList", booksByFilter);
  	
  	return "books";
  }
  
  // @RequestParam 을 사용해서 도서 ID 로 도서 검색하기
  // bookSerivce의 getBookById(String bookId) 메소드 호출하기
  @GetMapping("/book")
  public String requestBookById(@RequestParam String bookId, Model model) {
  	
  	Book bookById = bookService.getBookById(bookId);
  	model.addAttribute("bookById", bookById);  	
  	return "book";
  	
  }
  
  // 도서 등록
  @GetMapping("/regBook")
  public String regBook(@ModelAttribute("newBook") Book newBook) {
  	return "regBook";
  }
  
  /*
   *  @ModelAttribute("newBook") 을 사용하지 않는 방법
   @GetMapping("/regBook")
   public String regBook( Book newBook, Model model) {
     model.addAttribute("newBook", newBook);
  	 return "regBook";
   } 
   */
  
    @PostMapping("/regBookProcedure")
    public String regBookProcedure(@ModelAttribute("newBook") Book newBook) {
    	bookService.regNewBook(newBook);
    	return "redirect:/books";
    }
  
}



