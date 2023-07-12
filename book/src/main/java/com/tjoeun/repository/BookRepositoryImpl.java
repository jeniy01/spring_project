package com.tjoeun.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.tjoeun.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	private List<Book> listOfBooks = new ArrayList<Book>();
	
	public BookRepositoryImpl() {
		Book book1 = new Book("ISBN-13", "난생처음 자바", 29000);
		Book book2 = new Book("ISBN-14", "로마인이야기", 10000);
		Book book3 = new Book("ISBN-15", "실무 엑셀", 21000);
		Book book4 = new Book("ISBN-16", "한국인이야기", 20000);
		
		book4.setAuthor("더조은");
	  book4.setDescription("이 책은 초보자에게 어려운 자바 개념을 다양한 삽화와 도식을 통해 시각적으로 설명하여 비전공자도 쉽게 이해할 수 있도록 구성하였습니다.");
	  book4.setPublisher("이지스퍼블리싱");
	  book4.setCategory("인문교양");
	  book4.setUnitsInStock(90);
	  book4.setReleaseDate("2022/05/05");
	  
	  book1.setAuthor("우재남");
	  book1.setDescription("이 책은 초보자에게 어려운 자바 개념을 다양한 삽화와 도식을 통해 시각적으로 설명하여 비전공자도 쉽게 이해할 수 있도록 구성하였습니다.");
	  book1.setPublisher("한빛아카데미");
	  book1.setCategory("IT서적");
	  book1.setUnitsInStock(200);
	  book1.setReleaseDate("2023/06/30");
	  
	  book2.setAuthor("시오노나나미");
	  book2.setDescription("이 책은 방대한 자료를 취재.정리해가면서 엮은 거대한 로마 통사이면서현대를 어떻게 살아가야 하는지를 가르쳐 주는 지침서이다.");
	  book2.setPublisher("한길사");
	  book2.setCategory("인문교양");
	  book2.setUnitsInStock(100);
	  book2.setReleaseDate("1997/08/25");
	  
	  book3.setAuthor("정태호");
	  book3.setDescription("이 책은 엑셀의 3가지 핵심인 ‘수식’, ‘데이터’, ‘함수’를 중심으로 설명한다. ");
	  book3.setPublisher("이지스퍼블리싱");
	  book3.setCategory("IT서적");
	  book3.setUnitsInStock(150);
	  book3.setReleaseDate("2023/05/15");  
	  
	  listOfBooks.add(book1);
	  listOfBooks.add(book2);
	  listOfBooks.add(book3);
	  listOfBooks.add(book4);
	  
	}

	@Override
	public List<Book> getAllBookList() {
		return listOfBooks;
	}
	
	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory = new ArrayList<Book>();
		
		/*
		 * listOfBooks.size() <-- 3
		 * booksByCategory.size() <-- 0
		 */
		for(int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			// 파라미터로 전달받은 category 와 일치하는 분야의 책만 추가함
			if (category.equalsIgnoreCase(book.getCategory())) {
				booksByCategory.add(book);				
			}
		}		
		return booksByCategory;
	}
	
	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory  = new HashSet<Book>();
		
		Set<String> booksByFilter = filter.keySet();
		
		if(booksByFilter.contains("publisher")) {
			for(int j = 0; j < filter.get("publisher").size(); j++) {
				String publisherName = filter.get("publisher").get(j);
				
				for(int i = 0; i < listOfBooks.size(); i++) {
					Book book = listOfBooks.get(i);
					
					if(publisherName.equalsIgnoreCase(book.getPublisher())) {
						booksByPublisher.add(book);
					}
				}
			}
		}
		
		if(booksByFilter.contains("category")) {
			for(int i = 0; i < filter.get("category").size(); i++) {
				String category = filter.get("category").get(i);				
				List<Book> list = getBookListByCategory(category);
				booksByCategory.addAll(list);
			}
		}
		
		booksByCategory.retainAll(booksByPublisher);		
		return booksByCategory;
	}
	
	@Override
	public Book getBookById(String bookId) {
		Book book = null;
		
		for(int i = 0; i < listOfBooks.size(); i++) {
			Book tmpBook = listOfBooks.get(i);
			if(tmpBook != null && tmpBook.getBookId() != null 
				 && tmpBook.getBookId().equals(bookId)) {
				book = tmpBook;
				break;
			}
		}
		// 전달한 id 에 해당하는 도서가 없는 경우
		if(book == null) {
			throw new IllegalArgumentException("도서 ID 가 " + bookId + "인 도서를 찾을 수 없습니다");
		}	
		return book;
	}
	
	// 새 도서 등록하기
	@Override
	public void regNewBook(Book newBook) {
		listOfBooks.add(newBook);		
	}

}





