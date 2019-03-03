package com.example.Service;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.example.Model.Post;

@Service
public interface PostService {
public <S extends Post> S index(S entity) ;
	


	public Iterable<Post> search(QueryBuilder query) ;
	

	public Page<Post> search(QueryBuilder query, Pageable pageable) ;


	public Page<Post> search(SearchQuery searchQuery);
	

	
	public Page<Post> searchSimilar(Post entity, String[] fields, Pageable pageable) ;

	
	public void refresh() ;


	public Class<Post> getEntityClass();

	
	public Iterable<Post> findAll(Sort sort) ;
	
	public Page<Post> findAll(Pageable pageable) ;

	
	public <S extends Post> S save(S entity) ;

	
	public <S extends Post> Iterable<S> saveAll(Iterable<S> entities);

	
	public Optional<Post> findById(Long id);

	public boolean existsById(Long id) ;

	
	public Iterable<Post> findAll() ;

	
	public Iterable<Post> findAllById(Iterable<Long> ids);

	public long count() ;

	public void deleteById(Long id) ;


	public void delete(Post entity) ;

	public void deleteAll(Iterable<? extends Post> entities);

	
	public void deleteAll() ;


}
