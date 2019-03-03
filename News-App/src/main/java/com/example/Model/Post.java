package com.example.Model;

import java.util.List;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

public class Post {

	@Id
	private Long idPost;
	private String titlePost;
	private String contenuePost;
	private String datePost;
	@Lob
	private byte[] photoPost;
	@Lob
	private byte[] videoPost;
	
	@ManyToOne
	private Admin admin;
	@ManyToOne
	private Categorie categoriePost;
	@OneToMany
	private List<Like> listLike;
	private List<Comment> listComment;
	
	
	
}
