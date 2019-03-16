package com.example.Service;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.example.Model.Like;

@Service
public interface LikeService {
public <S extends Like> S index(S entity) ;
	


	public Iterable<Like> search(QueryBuilder query) ;
	

	public Page<Like> search(QueryBuilder query, Pageable pageable) ;


	public Page<Like> search(SearchQuery searchQuery);
	

	
	public Page<Like> searchSimilar(Like entity, String[] fields, Pageable pageable) ;

	
	public void refresh() ;


	public Class<Like> getEntityClass();

	
	public Iterable<Like> findAll(Sort sort) ;
	
	public Page<Like> findAll(Pageable pageable) ;

	
	public <S extends Like> S save(S entity) ;

	
	public <S extends Like> Iterable<S> saveAll(Iterable<S> entities);

	
	public Optional<Like> findById(String id);

	public boolean existsById(String id) ;

	
	public Iterable<Like> findAll() ;

	
	public Iterable<Like> findAllById(Iterable<String> ids);

	public long count() ;

	public void deleteById(String id) ;


	public void delete(Like entity) ;

	public void deleteAll(Iterable<? extends Like> entities);

	
	public void deleteAll() ;


}
