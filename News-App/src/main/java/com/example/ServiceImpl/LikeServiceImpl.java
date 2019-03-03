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


import com.example.Model.Like;
import com.example.Repository.LikeRepository;
import com.example.Service.LikeService;

@EnableElasticsearchRepositories("com.example.Repository")
@Service
public class LikeServiceImpl implements LikeService{

	@Autowired
	LikeRepository likeRepository;
	
	@Override
	public <S extends Like> S index(S entity) {
		return likeRepository.index(entity);
	}

	@Override
	public Iterable<Like> search(QueryBuilder query) {
		return likeRepository.search(query);
	}

	@Override
	public Page<Like> search(QueryBuilder query, Pageable pageable) {
		return likeRepository.search(query, pageable);
	}

	@Override
	public Page<Like> search(SearchQuery searchQuery) {
		return likeRepository.search(searchQuery);
	}

	@Override
	public Page<Like> searchSimilar(Like entity, String[] fields, Pageable pageable) {
		return likeRepository.searchSimilar(entity, fields, pageable);
	}

	@Override
	public void refresh() {
		likeRepository.refresh();
		
	}

	@Override
	public Class<Like> getEntityClass() {
		return likeRepository.getEntityClass();
	}

	@Override
	public Iterable<Like> findAll(Sort sort) {
		return likeRepository.findAll();
	}

	@Override
	public Page<Like> findAll(Pageable pageable) {
		return likeRepository.findAll(pageable);
	}

	@Override
	public <S extends Like> S save(S entity) {
		return likeRepository.save(entity);
	}

	@Override
	public <S extends Like> Iterable<S> saveAll(Iterable<S> entities) {
		return likeRepository.saveAll(entities);
	}

	@Override
	public Optional<Like> findById(Long id) {
		return likeRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return likeRepository.existsById(id);
	}

	@Override
	public Iterable<Like> findAll() {
		return likeRepository.findAll();
	}

	@Override
	public Iterable<Like> findAllById(Iterable<Long> ids) {
		return likeRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return likeRepository.count();
	}

	@Override
	public void deleteById(Long id) {
         likeRepository.deleteById(id);		
	}

	@Override
	public void delete(Like entity) {
         likeRepository.delete(entity);	
	}

	@Override
	public void deleteAll(Iterable<? extends Like> entities) {
		likeRepository.deleteAll(entities);;
		
	}

	@Override
	public void deleteAll() {
      		likeRepository.deleteAll();
	}

}
