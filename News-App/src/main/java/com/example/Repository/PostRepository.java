package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Categorie;
import com.example.Model.Post;

@Repository
public interface PostRepository extends ElasticsearchRepository<Post, String>{
	Iterable<Post> findByCategoriePost(Categorie categorie);
}
