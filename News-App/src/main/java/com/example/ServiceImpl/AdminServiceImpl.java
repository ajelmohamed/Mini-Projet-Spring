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

import com.example.Model.Admin;
import com.example.Model.User;
import com.example.Repository.AdminRepository;
import com.example.Service.AdminService;
@EnableElasticsearchRepositories("com.example.Repository")
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public <S extends Admin> S index(S entity) {
		return adminRepository.index(entity);
	}

	@Override
	public Iterable<Admin> search(QueryBuilder query) {
		return adminRepository.search(query);
	}

	@Override
	public Page<Admin> search(QueryBuilder query, Pageable pageable) {
		return adminRepository.search(query, pageable);
	}

	@Override
	public Page<Admin> search(SearchQuery searchQuery) {
		return adminRepository.search(searchQuery);
	}

	@Override
	public Page<Admin> searchSimilar(Admin entity, String[] fields, Pageable pageable) {
		return adminRepository.searchSimilar(entity, fields, pageable);
	}

	@Override
	public void refresh() {
		adminRepository.refresh();
		
	}

	@Override
	public Class<Admin> getEntityClass() {
		return adminRepository.getEntityClass();
	}

	@Override
	public Iterable<Admin> findAll(Sort sort) {
		return adminRepository.findAll();
	}

	@Override
	public Page<Admin> findAll(Pageable pageable) {
		return adminRepository.findAll(pageable);
	}

	@Override
	public <S extends Admin> S save(S entity) {
		return adminRepository.save(entity);
	}

	@Override
	public <S extends Admin> Iterable<S> saveAll(Iterable<S> entities) {
		return adminRepository.saveAll(entities);
	}

	@Override
	public Optional<Admin> findById(String id) {
		return adminRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return adminRepository.existsById(id);
	}

	@Override
	public Iterable<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Iterable<Admin> findAllById(Iterable<String> ids) {
		return adminRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return adminRepository.count();
	}

	@Override
	public void deleteById(String id) {
         adminRepository.deleteById(id);		
	}

	@Override
	public void delete(Admin entity) {
         adminRepository.delete(entity);	
	}

	@Override
	public void deleteAll(Iterable<? extends Admin> entities) {
		adminRepository.deleteAll(entities);;
		
	}

	@Override
	public void deleteAll() {
      		adminRepository.deleteAll();
	}
	@Override
	 public ResponseEntity<Admin> loginAdmin(String email,String password) {
		Admin admin=adminRepository.findByEmailAdminAndPasswordAdmin(email,password);
		if(admin == null) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);	
			}
		
       return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Admin> registerAdmin(Admin admin) {
		Admin admin1=adminRepository.findByEmailAdmin(admin.getEmailAdmin());
		if(admin1 != null) {
		    System.out.println(admin1.getEmailAdmin());
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);	
			}
		this.save(admin);
       return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

}
