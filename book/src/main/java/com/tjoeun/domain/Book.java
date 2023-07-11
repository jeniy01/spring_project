package com.tjoeun.domain;

import lombok.Data;

@Data
public class Book {
	private String bookId;					// 책 ID
	private String name;						// 이름
	private int unitPrice;					// 가격
	private String author;					// 저자
	private String description;			// 설명
	private String publisher;				// 출판사
	private String category;				// 분류
	private long unitsInStock;			// 재고 수
	private String releaseDate;			// 출판일 (월/년)
	private String condition;				// 상태 (신규/중고/전자책)
	private String bookImage;				// 이미지
	
	public Book() {}
	
	public Book(String bookId, String name, int unitPrice) {
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
}
