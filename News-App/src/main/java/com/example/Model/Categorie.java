package com.example.Model;

import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

public class Categorie {
	@Id
	private Long idCategorie;
	private String TitleCategorie;
	private String DescriptionCategorie;
	
	
}
