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

import com.example.Model.Comment;
import com.example.Model.Comment;
import com.example.Repository.CommentRepository;
import com.example.Service.AdminService;
import com.example.Service.CommentService;
@EnableElasticsearchRepositories("com.example.Repository")
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public <S extends Comment> S index(S entity) {
		return commentRepository.index(entity);
	}

	@Override
	public Iterable<Comment> search(QueryBuilder query) {
		return commentRepository.search(query);
	}

	@Override
	public Page<Comment> search(QueryBuilder query, Pageable pageable) {
		return commentRepository.search(query, pageable);
	}

	@Override
	public Page<Comment> search(SearchQuery searchQuery) {
		return commentRepository.search(searchQuery);
	}

	@Override
	public Page<Comment> searchSimilar(Comment entity, String[] fields, Pageable pageable) {
		return commentRepository.searchSimilar(entity, fields, pageable);
	}

	@Override
	public void refresh() {
		commentRepository.refresh();
		
	}

	@Override
	public Class<Comment> getEntityClass() {
		return commentRepository.getEntityClass();
	}

	@Override
	public Iterable<Comment> findAll(Sort sort) {
		return commentRepository.findAll();
	}

	@Override
	public Page<Comment> findAll(Pageable pageable) {
		return commentRepository.findAll(pageable);
	}

	@Override
	public <S extends Comment> S save(S entity) {
		return commentRepository.save(entity);
	}

	@Override
	public <S extends Comment> Iterable<S> saveAll(Iterable<S> entities) {
		return commentRepository.saveAll(entities);
	}

	@Override
	public Optional<Comment> findById(String id) {
		return commentRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return commentRepository.existsById(id);
	}

	@Override
	public Iterable<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Iterable<Comment> findAllById(Iterable<String> ids) {
		return commentRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return commentRepository.count();
	}

	@Override
	public void deleteById(String id) {
         commentRepository.deleteById(id);		
	}

	@Override
	public void delete(Comment entity) {
         commentRepository.delete(entity);	
	}

	@Override
	public void deleteAll(Iterable<? extends Comment> entities) {
		commentRepository.deleteAll(entities);;
		
	}

	@Override
	public void deleteAll() {
      		commentRepository.deleteAll();
	}

}
