package com.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/t1/{bookId}")
	public String t1(@PathVariable String bookId, Model model) {
		System.out.println("도서 ID : " + bookId);
		model.addAttribute("bookId", "도서 ID : " + bookId);
		return "test/t1";		
	}
	
	@GetMapping("/t2/{category}/publisher/{publisher}")
	public String t2(@PathVariable String category, 
			             @PathVariable String publisher,
			             Model model) {
		System.out.println("도서분야 : " + category);
		System.out.println("출 판 사 : " + publisher);
		model.addAttribute("bookInfo", "<br>도서분야 : " + category  
		                              + "<br>출 판 사 : " + publisher);
		return "test/t2";		
	}
	
	
	@GetMapping("/t3/{bookId}")
	public String t3(@PathVariable String bookId,
			             @MatrixVariable String category, Model model) {
		System.out.println("도서 ID  : " + bookId);
		System.out.println("도서분야 : " + category);
		model.addAttribute("bookInfo",  "<br>도서 ID  : " + bookId 
				                          + "<br>도서분야 : " + category);
		return "test/t3";		
	}
	
	@GetMapping("/t5/{bookId}/category/{category}")
	public String t5(@MatrixVariable(value="publisher", pathVar="bookId") String d1,
			             @MatrixVariable(value="publisher", pathVar="category") String d2,
			             Model model) {
		System.out.println("출 판 사 : " + d1);
		System.out.println("도서분야 : " + d2);
		model.addAttribute("data", "<br>출 판 사 : " + d1 + "<br>출 판 사 : " + d2);
		return "test/t5";
		
	}
	
	@GetMapping("/t6/{bookId}")
	public String t6(@PathVariable String bookId,
			             @MatrixVariable(required=false, defaultValue="더조은") String d1,
			             Model model) {
		System.out.println("도서 ID  : " + bookId);
		System.out.println("출 판 사 : " + d1);
		model.addAttribute("data", "<br>도서 ID  : " + bookId + "<br>출 판 사 : " + d1);
		return "test/t6";
	}
	
	@GetMapping("/t7/{bookId}/category/{category}")
	public String t7(@PathVariable String bookId, @PathVariable String category,
			             @MatrixVariable MultiValueMap<String, String> mvm1,
			             @MatrixVariable(pathVar="category") MultiValueMap<String, String> mvm2,
			             Model model) {
		
		System.out.println("도서 ID  : " + bookId);
		System.out.println("도서분류 : " + category);
		System.out.println("mvm1     : " + mvm1);
		System.out.println("mvm2     : " + mvm2);
		
		model.addAttribute("bookData", "<br>" + mvm1 + "<br>" + mvm2);
		
		return "test/t7";
	}
	
	

}






