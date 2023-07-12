package com.tjoeun.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.domain.Book;
import com.tjoeun.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBookList() {		
		List<Book> bookList = bookRepository.getAllBookList();
		System.out.println(bookList.size());
		return bookList;
	}
	
	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
		return booksByCategory;
	}
	
	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {		
		Set<Book> booksByfilter = bookRepository.getBookListByFilter(filter);
		return booksByfilter;
	}
	
	@Override
	public Book getBookById(String bookId) {
		Book bookById = bookRepository.getBookById(bookId);		
		return bookById;
	}
	
	// 새 도서 등록하기
	@Override
	public void regNewBook(Book newBook) {
		bookRepository.regNewBook(newBook);		
	}

}
