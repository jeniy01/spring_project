package com.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjoeun.dto.Member;

@Controller
@RequestMapping("/test")
public class TestController {
	
	// @PathVariable : {} 에 전달된 값을 받음
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
	
	// @MatrixVariable <-- ; 표시하고 지정한 변수=값 을 받음
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
	
  // @RequestParam <-- ? 표시하고 지정한 변수=값 을 받음
	@GetMapping("/t8")
	public String requestParamMethod(@RequestParam String id, Model model) {
		System.out.println("도서 ID " + id);
		model.addAttribute("bookInfo", "<br>도서 ID : " + id);
		return "test/t8";
	}
	
	
	@GetMapping("/regForm")
	public String regForm(Model model) {
		
		Member m1 = new Member();
		System.out.println("--@GetMapping(/regForm)--------------");
		System.out.println("아이디 : " + m1.getId());
		System.out.println("비밀번호 : " + m1.getPasswd());
		System.out.println("거주지 : " + m1.getCity());
		System.out.println("성  별 : " + m1.getGender());
		System.out.println("취  미 : " + m1.getHobby());
		
		model.addAttribute("member", m1);		
		
		return "test/form_test01";
	}
	
	@PostMapping("/regProcedure")
	public String submitForm(Member m1, Model model) {
		
		System.out.println("--@PostMapping(/member)--------------");
		System.out.println("아 이 디 : " + m1.getId());
		System.out.println("비밀번호 : " + m1.getPasswd());
		System.out.println("거 주 지 : " + m1.getCity());
		System.out.println("성    별 : " + m1.getGender());
		System.out.print("취  미 : ");
		for(int i = 0; i < m1.getHobby().length; i++) {
			System.out.print(m1.getHobby()[i] + " ");
		}
		System.out.println();
		
		model.addAttribute("member", m1);				
		return "test/form_test02";
	}
	
	
	@GetMapping("/t9")
	public String showForm() {
		return "test/t9";
	}
	
	// return 값인 문자열이 title 이란 이름으로
	// requestScope 에 저장됨
	@ModelAttribute("title")
	public String setTitle() {
		return "@ModelAttribute 유형";
	}
	
	/*
	   return 값인 문자열이 subTitle 이란 이름으로
	   requestScope 에 저장됨
	@ModelAttribute("subTitle")
	public String setSubTitle() {
		return "메소드 수준에서 @ModelAttribute 적용하기";
	}
	*/
	
	@ModelAttribute
	public void setSubTitle(Model model) {
		model.addAttribute("subTitle", "메소드 수준에서 @ModelAttribute 적용하기");
	}

}






