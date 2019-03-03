package com.example.Service;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.example.Model.User;

@Service
public interface UserService {
public <S extends User> S index(S entity) ;
	


	public Iterable<User> search(QueryBuilder query) ;
	

	public Page<User> search(QueryBuilder query, Pageable pageable) ;


	public Page<User> search(SearchQuery searchQuery);
	

	
	public Page<User> searchSimilar(User entity, String[] fields, Pageable pageable) ;

	
	public void refresh() ;


	public Class<User> getEntityClass();

	
	public Iterable<User> findAll(Sort sort) ;
	
	public Page<User> findAll(Pageable pageable) ;

	
	public <S extends User> S save(S entity) ;

	
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities);

	
	public Optional<User> findById(Long id);

	public boolean existsById(Long id) ;

	
	public Iterable<User> findAll() ;

	
	public Iterable<User> findAllById(Iterable<Long> ids);

	public long count() ;

	public void deleteById(Long id) ;


	public void delete(User entity) ;

	public void deleteAll(Iterable<? extends User> entities);

	
	public void deleteAll() ;


}
