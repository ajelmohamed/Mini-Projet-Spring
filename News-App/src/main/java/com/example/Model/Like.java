package com.example.Model;

import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

public class Like {

	@Id
	private Long idLike;
	@ManyToOne
	private User user;
	
}
