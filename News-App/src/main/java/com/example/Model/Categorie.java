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
@Document(indexName="appnews",type="categorie",shards=2)
public class Categorie {
	@Id
	private Long idCategorie;
	private String TitleCategorie;
	private String DescriptionCategorie;
	
	
}
