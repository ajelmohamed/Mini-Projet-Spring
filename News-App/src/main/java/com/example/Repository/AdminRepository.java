package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Admin;
@Repository
public interface AdminRepository extends ElasticsearchRepository<Admin, Long> {

}
