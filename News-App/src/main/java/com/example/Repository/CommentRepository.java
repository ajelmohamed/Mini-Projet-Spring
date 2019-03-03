package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.Model.Comment;

public interface CommentRepository  extends ElasticsearchRepository<Comment, Long>{

}
