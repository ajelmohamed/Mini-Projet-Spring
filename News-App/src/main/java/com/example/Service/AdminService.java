package com.example.Service;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Model.Admin;
import com.example.Model.User;
@Service
public interface AdminService  {

	
	public <S extends Admin> S index(S entity) ;
	


	public Iterable<Admin> search(QueryBuilder query) ;
	

	public Page<Admin> search(QueryBuilder query, Pageable pageable) ;


	public Page<Admin> search(SearchQuery searchQuery);
	

	
	public Page<Admin> searchSimilar(Admin entity, String[] fields, Pageable pageable) ;

	
	public void refresh() ;


	public Class<Admin> getEntityClass();

	
	public Iterable<Admin> findAll(Sort sort) ;
	
	public Page<Admin> findAll(Pageable pageable) ;

	
	public <S extends Admin> S save(S entity) ;

	
	public <S extends Admin> Iterable<S> saveAll(Iterable<S> entities);

	
	public Optional<Admin> findById(String id);

	public boolean existsById(String id) ;

	
	public Iterable<Admin> findAll() ;

	
	public Iterable<Admin> findAllById(Iterable<String> ids);

	public long count() ;

	public void deleteById(String id) ;


	public void delete(Admin entity) ;

	public void deleteAll(Iterable<? extends Admin> entities);

	
	public void deleteAll() ;
	public ResponseEntity<Admin> registerAdmin(Admin admin) ;
	public ResponseEntity<Admin> loginAdmin(String email,String password);
}
