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

import com.example.Model.Post;
import com.example.Repository.PostRepository;
import com.example.Service.PostService;

@EnableElasticsearchRepositories("com.example.Repository")
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;
	
	@Override
	public <S extends Post> S index(S entity) {
		return postRepository.index(entity);
	}

	@Override
	public Iterable<Post> search(QueryBuilder query) {
		return postRepository.search(query);
	}

	@Override
	public Page<Post> search(QueryBuilder query, Pageable pageable) {
		return postRepository.search(query, pageable);
	}

	@Override
	public Page<Post> search(SearchQuery searchQuery) {
		return postRepository.search(searchQuery);
	}

	@Override
	public Page<Post> searchSimilar(Post entity, String[] fields, Pageable pageable) {
		return postRepository.searchSimilar(entity, fields, pageable);
	}

	@Override
	public void refresh() {
		postRepository.refresh();
		
	}

	@Override
	public Class<Post> getEntityClass() {
		return postRepository.getEntityClass();
	}

	@Override
	public Iterable<Post> findAll(Sort sort) {
		return postRepository.findAll();
	}

	@Override
	public Page<Post> findAll(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public <S extends Post> S save(S entity) {
		return postRepository.save(entity);
	}

	@Override
	public <S extends Post> Iterable<S> saveAll(Iterable<S> entities) {
		return postRepository.saveAll(entities);
	}

	@Override
	public Optional<Post> findById(Long id) {
		return postRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return postRepository.existsById(id);
	}

	@Override
	public Iterable<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Iterable<Post> findAllById(Iterable<Long> ids) {
		return postRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return postRepository.count();
	}

	@Override
	public void deleteById(Long id) {
         postRepository.deleteById(id);		
	}

	@Override
	public void delete(Post entity) {
         postRepository.delete(entity);	
	}

	@Override
	public void deleteAll(Iterable<? extends Post> entities) {
		postRepository.deleteAll(entities);;
		
	}

	@Override
	public void deleteAll() {
      		postRepository.deleteAll();
	}

}
