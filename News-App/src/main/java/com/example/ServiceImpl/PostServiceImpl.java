package com.example.ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Service;

import com.example.Model.Categorie;
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
	public Optional<Post> findById(String id) {
		return postRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return postRepository.existsById(id);
	}

	@Override
	public Iterable<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Iterable<Post> findAllById(Iterable<String> ids) {
		return postRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return postRepository.count();
	}

	@Override
	public void deleteById(String id) {
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

	@Override
	public Iterable<Post> findPostCategorie(String categorie) {
		// TODO Auto-generated method stub
		return postRepository.findByCategoriePost_IdCategorie(categorie);
	}

	@Override
	public Iterable<Post> searchPosts(String message) {
		// TODO Auto-generated method stub
		return postRepository.findByCategoriePost_TitleCategorieOrCategoriePost_DescriptionCategorieOrTitlePostOrContenuePostOrAdmin_NomAdminOrAdmin_PrenomAdmin(message);
	}

	@Override
	public Iterable<Post> findPopularPost() {
		// TODO Auto-generated method stub
		Iterable<Post> p=postRepository.findAll();
		Iterator<Post> i=p.iterator();
		ArrayList<Post> lp =new ArrayList<Post>();
		while(i.hasNext()) {
		lp.add(i.next());
		}
		Collections.sort(lp);
		
		return lp.subList(0, 4);
	}
	
	@Override
	public Iterable<Post> findLatestPost() {
		// TODO Auto-generated method stub

		Iterable<Post> p=postRepository.findAll();
		Iterator<Post> i=p.iterator();
		ArrayList<Post> lp =new ArrayList<Post>();
		while(i.hasNext()) {
		lp.add(i.next());
		}
		
		return lp.subList(lp.size()-4,lp.size()-1);
		
	}


}
