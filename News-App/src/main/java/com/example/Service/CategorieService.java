package com.example.Service;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.example.Model.Categorie;
@Service
public interface CategorieService {
	
	public <S extends Categorie> S index(S entity) ;
	


	public Iterable<Categorie> search(QueryBuilder query) ;
	

	public Page<Categorie> search(QueryBuilder query, Pageable pageable) ;


	public Page<Categorie> search(SearchQuery searchQuery);
	

	
	public Page<Categorie> searchSimilar(Categorie entity, String[] fields, Pageable pageable) ;

	
	public void refresh() ;


	public Class<Categorie> getEntityClass();

	
	public Iterable<Categorie> findAll(Sort sort) ;
	
	public Page<Categorie> findAll(Pageable pageable) ;

	
	public <S extends Categorie> S save(S entity) ;

	
	public <S extends Categorie> Iterable<S> saveAll(Iterable<S> entities);

	
	public Optional<Categorie> findById(Long id);

	public boolean existsById(Long id) ;

	
	public Iterable<Categorie> findAll() ;

	
	public Iterable<Categorie> findAllById(Iterable<Long> ids);

	public long count() ;

	public void deleteById(Long id) ;


	public void delete(Categorie entity) ;

	public void deleteAll(Iterable<? extends Categorie> entities);

	
	public void deleteAll() ;

}
