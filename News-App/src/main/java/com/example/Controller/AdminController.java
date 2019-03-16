package com.example.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Admin;
import com.example.Model.User;
import com.example.Service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
 @Autowired 
 AdminService adminService;
 
 
 
 @RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
 public ResponseEntity<Admin>  login(@RequestParam(required=false,name="email") String email,@RequestParam(required=false,name="password") String password)
 {   		

	 return adminService.loginAdmin(email,password);
 }
 
 
 @RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
 public ResponseEntity<Admin>  registerAdmin(@RequestBody Admin admin)
 {
	return adminService.registerAdmin(admin);
 }
 
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
