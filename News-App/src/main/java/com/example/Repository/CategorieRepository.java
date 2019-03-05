package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Categorie;
@Repository

public interface CategorieRepository extends ElasticsearchRepository<Categorie, Long> {

}
