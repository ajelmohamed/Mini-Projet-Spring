package com.example.Service;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.example.Model.Comment;
@Service
public interface CommentService  {


	
	public <S extends Comment> S index(S entity) ;
	


	public Iterable<Comment> search(QueryBuilder query) ;
	

	public Page<Comment> search(QueryBuilder query, Pageable pageable) ;


	public Page<Comment> search(SearchQuery searchQuery);
	

	
	public Page<Comment> searchSimilar(Comment entity, String[] fields, Pageable pageable) ;

	
	public void refresh() ;


	public Class<Comment> getEntityClass();

	
	public Iterable<Comment> findAll(Sort sort) ;
	
	public Page<Comment> findAll(Pageable pageable) ;

	
	public <S extends Comment> S save(S entity) ;

	
	public <S extends Comment> Iterable<S> saveAll(Iterable<S> entities);

	
	public Optional<Comment> findById(Long id);

	public boolean existsById(Long id) ;

	
	public Iterable<Comment> findAll() ;

	
	public Iterable<Comment> findAllById(Iterable<Long> ids);

	public long count() ;

	public void deleteById(Long id) ;


	public void delete(Comment entity) ;

	public void deleteAll(Iterable<? extends Comment> entities);

	
	public void deleteAll() ;

}
