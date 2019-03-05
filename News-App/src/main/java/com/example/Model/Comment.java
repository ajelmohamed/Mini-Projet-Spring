package com.example.Model;

import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName="comment",type="comment",shards=2)
public class Comment {

	@Id
	private Long idComment;
	private String ContenuComment;
	@ManyToOne
	private User user;
	
	

}
