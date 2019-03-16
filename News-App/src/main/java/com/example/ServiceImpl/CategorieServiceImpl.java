package com.example.ServiceImpl;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Service;

import com.example.Model.Categorie;
import com.example.Repository.CategorieRepository;
import com.example.Service.CategorieService;


@EnableElasticsearchRepositories("com.example.Repository")
@Service
public class CategorieServiceImpl implements CategorieService{
	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public <S extends Categorie> S index(S entity) {
		return categorieRepository.index(entity);
	}

	@Override
	public Iterable<Categorie> search(QueryBuilder query) {
		return categorieRepository.search(query);
	}

	@Override
	public Page<Categorie> search(QueryBuilder query, Pageable pageable) {
		return categorieRepository.search(query, pageable);
	}

	@Override
	public Page<Categorie> search(SearchQuery searchQuery) {
		return categorieRepository.search(searchQuery);
	}

	@Override
	public Page<Categorie> searchSimilar(Categorie entity, String[] fields, Pageable pageable) {
		return categorieRepository.searchSimilar(entity, fields, pageable);
	}

	@Override
	public void refresh() {
		categorieRepository.refresh();
		
	}

	@Override
	public Class<Categorie> getEntityClass() {
		return categorieRepository.getEntityClass();
	}

	@Override
	public Iterable<Categorie> findAll(Sort sort) {
		return categorieRepository.findAll();
	}

	@Override
	public Page<Categorie> findAll(Pageable pageable) {
		return categorieRepository.findAll(pageable);
	}

	@Override
	public <S extends Categorie> S save(S entity) {
		return categorieRepository.save(entity);
	}

	@Override
	public <S extends Categorie> Iterable<S> saveAll(Iterable<S> entities) {
		return categorieRepository.saveAll(entities);
	}

	@Override
	public Optional<Categorie> findById(String id) {
		return categorieRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return categorieRepository.existsById(id);
	}

	@Override
	public Iterable<Categorie> findAll() {
		return categorieRepository.findAll();
	}

	@Override
	public Iterable<Categorie> findAllById(Iterable<String> ids) {
		return categorieRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return categorieRepository.count();
	}

	@Override
	public void deleteById(String id) {
         categorieRepository.deleteById(id);		
	}

	@Override
	public void delete(Categorie entity) {
         categorieRepository.delete(entity);	
	}

	@Override
	public void deleteAll(Iterable<? extends Categorie> entities) {
		categorieRepository.deleteAll(entities);;
		
	}

	@Override
	public void deleteAll() {
      		categorieRepository.deleteAll();
	}


}
