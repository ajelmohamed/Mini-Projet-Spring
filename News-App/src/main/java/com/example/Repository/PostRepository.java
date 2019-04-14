package com.example.Repository;


import org.hibernate.mapping.List;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Categorie;
import com.example.Model.Post;

@Repository
public interface PostRepository extends ElasticsearchRepository<Post, String>{
	Iterable<Post> findByCategoriePost_IdCategorie(String categorie);
	Iterable<Post> findByCategoriePost_TitleCategorieOrCategoriePost_DescriptionCategorieOrTitlePostOrContenuePostOrAdmin_NomAdminOrAdmin_PrenomAdmin(String message);

}
