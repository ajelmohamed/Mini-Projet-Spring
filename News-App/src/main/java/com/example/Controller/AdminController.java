package com.example.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Admin;
import com.example.Service.AdminService;

@RestController(value="/admins")
public class AdminController {
 @Autowired 
 AdminService adminService;
 
 @PostMapping("/saveAdmin")
 public void  saveAdmin(@RequestBody Admin admin)
 {
	 adminService.save(admin);
 }
 
 @GetMapping("/findAdmin/{id}")
 public Optional<Admin> findAdmin(@PathVariable("id") String id)
 {
	 return adminService.findById(id);
 }
 
 
 @GetMapping("/findAllAdmin")
 public Iterable<Admin> findAllAdmin()
 {
	 return adminService.findAll();
 }
 @PutMapping("/updateAdmin/{id}")
 public  ResponseEntity<Object> updateAdmin(@RequestBody Admin admin ,@PathVariable("id") String id)
 {
		Optional<Admin> adminOptional=adminService.findById(id);
		if (!adminOptional.isPresent())
			return  ResponseEntity.notFound().build() ;
		admin.setIdAdmin(id);
		adminService.save(admin);
		return ResponseEntity.noContent().build();

 }
 @DeleteMapping("/deleteAdmin/{id}")
 public void deleteAdmin(@PathVariable("id") String id)
 {
	 adminService.deleteById(id);
 }
 @DeleteMapping("/deleteAllAdmin")
 public void deleteAllAdmin()
 {
	 adminService.deleteAll();
 }
 
}
