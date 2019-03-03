package com.example.Model;

import java.util.List;

import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName="appnews",type="user",shards=2)
public class User {
	@Id
	private Long idUser;
	private String nomUser;
	private String prenomUser;
	private String emailUser;
	private String passwordUser;
	@Lob
	private byte[] avatarUser;
	

}
