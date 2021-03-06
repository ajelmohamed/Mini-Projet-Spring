package com.example.ServiceImpl;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Model.User;
import com.example.Repository.UserRepository;
import com.example.Service.UserService;
import com.example.Service.UserService;
@EnableElasticsearchRepositories("com.example.Repository")
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public <S extends User> S index(S entity) {
		return userRepository.index(entity);
	}

	@Override
	public Iterable<User> search(QueryBuilder query) {
		return userRepository.search(query);
	}

	@Override
	public Page<User> search(QueryBuilder query, Pageable pageable) {
		return userRepository.search(query, pageable);
	}

	@Override
	public Page<User> search(SearchQuery searchQuery) {
		return userRepository.search(searchQuery);
	}

	@Override
	public Page<User> searchSimilar(User entity, String[] fields, Pageable pageable) {
		return userRepository.searchSimilar(entity, fields, pageable);
	}

	@Override
	public void refresh() {
		userRepository.refresh();
		
	}

	@Override
	public Class<User> getEntityClass() {
		return userRepository.getEntityClass();
	}

	@Override
	public Iterable<User> findAll(Sort sort) {
		return userRepository.findAll();
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}

	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		return userRepository.saveAll(entities);
	}

	@Override
	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return userRepository.existsById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Iterable<User> findAllById(Iterable<String> ids) {
		return userRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(String id) {
         userRepository.deleteById(id);		
	}

	@Override
	public void delete(User entity) {
         userRepository.delete(entity);	
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		userRepository.deleteAll(entities);;
		
	}

	@Override
	public void deleteAll() {
      		userRepository.deleteAll();
	}

	@Override
	 public ResponseEntity<User> loginUser(String email,String password) {
		User user=userRepository.findByEmailUserAndPasswordUser(email,password);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);	
			}
		
        return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> registerUser(User user) {
		User user1=userRepository.findByEmailUser(user.getEmailUser());
		if(user1 != null) {
		    System.out.println(user1.getEmailUser());
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);	
			}
		this.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
