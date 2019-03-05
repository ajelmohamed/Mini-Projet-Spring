package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Like;

@Repository
public interface LikeRepository extends ElasticsearchRepository<Like, Long> {

}
