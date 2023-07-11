package com.tjoeun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tjoeun.domain.Book;
import com.tjoeun.repository.BookRepository;

public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBookList() {
		return bookRepository.getAllBookList();
	}
}
