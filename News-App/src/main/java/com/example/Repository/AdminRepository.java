package com.example.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Admin;
import com.example.Model.User;
@Repository
public interface AdminRepository extends ElasticsearchRepository<Admin, String> {
	Admin findByEmailAdminAndPasswordAdmin(String email,String password);

	Admin findByEmailAdmin(String emailAdmin);
}
