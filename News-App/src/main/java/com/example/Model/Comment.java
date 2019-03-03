package com.example.Model;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

public class Comment {

	@Id
	private Long idComment;
	private String ContenuComment;
	@ManyToOne
	private User user;
	
	

}
