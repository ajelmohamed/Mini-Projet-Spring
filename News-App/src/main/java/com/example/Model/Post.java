package com.example.Model;

import java.util.List;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName="post",type="post",shards=2)
public class Post implements Comparable<Post>{
	
	@Id
	private String idPost;
	
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
	@OneToMany
	private List<Comment> listComment;
	@Override
	 public int compareTo(Post emp) {
	  
	        return ( emp.listComment.size() - this.listComment.size());
	 }
}
