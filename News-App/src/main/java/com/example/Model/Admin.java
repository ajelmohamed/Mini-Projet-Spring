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
@Document(indexName="appnews",type="admin",shards=2)
public class Admin {
	
@Id
private Long idAdmin;
private String nomAdmin;
private String prenomAdmin;
private String emailAdmin;
private String passwordAdmin;
@Lob
private byte[] avatarAdmin;
@ManyToMany()
private List<Post>posts;



}
