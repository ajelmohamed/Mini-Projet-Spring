package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String>{


	User findByEmailUserAndPasswordUser(String email,String password);

	User findByEmailUser(String emailUser);

}
