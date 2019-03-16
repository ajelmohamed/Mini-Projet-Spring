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
@Document(indexName="like",type="like",shards=2)
public class Like {

	@Id
	private String idLike;
	@ManyToOne
	private User user;
	
}
