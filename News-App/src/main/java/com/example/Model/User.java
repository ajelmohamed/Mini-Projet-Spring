package com.example.Model;


import javax.persistence.Lob;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName="user",type="user",shards=2)
public class User {
	@Id
	private String idUser;
	private String nomUser;
	private String prenomUser;
	private String emailUser;
	private String passwordUser;
	@Lob
	private byte[] avatarUser;
	

}
