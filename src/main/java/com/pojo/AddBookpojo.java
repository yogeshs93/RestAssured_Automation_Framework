package com.pojo;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder(setterPrefix = "set")
public class AddBookpojo {
	
	private String name;
	private String isbn;
	private String aisle;
	private String author;
	

}
