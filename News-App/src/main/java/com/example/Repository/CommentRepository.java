package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Comment;
@Repository

public interface CommentRepository  extends ElasticsearchRepository<Comment, String>{

}
