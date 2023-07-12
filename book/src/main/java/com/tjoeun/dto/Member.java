package com.tjoeun.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	
	private int id;
	private String passwd;
	private String city;
	private String gender;
	private String[] hobby;
	private Date birthDate; 	

}
