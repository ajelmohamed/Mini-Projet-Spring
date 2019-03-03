package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.Model.Categorie;

public interface CategorieRepository extends ElasticsearchRepository<Categorie, Long> {

}
