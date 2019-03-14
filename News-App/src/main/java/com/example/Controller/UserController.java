package com.example.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.User;
import com.example.Service.UserService;

@RestController(value="/users")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
	@Autowired 
	 UserService userService;
	
	 @PostMapping("/login")
	 public ResponseEntity<User>  login(@RequestParam String email,@RequestParam String password)
	 {
		 return userService.loginUser(email,password);
	 }
	 
	 
	 @PostMapping("/saveUser")
	 public void  saveUser(@RequestBody User user)
	 {
		 userService.save(user);
	 }
	 
	 @GetMapping("/findUser/{id}")
	 public Optional<User> findUser(@PathVariable("id") Long id)
	 {
		 return userService.findById(id);
	 }
	 
	 
	 @GetMapping("/findAllUser")
	 public Iterable<User> findAllUser()
	 {
		 return userService.findAll();
	 }
	 @PutMapping("/updateUser/{id}")
	 public  ResponseEntity<Object> updateUser(@RequestBody User user ,@PathVariable("id") Long id)
	 {
			Optional<User> userOptional=userService.findById(id);
			if (!userOptional.isPresent())
				return  ResponseEntity.notFound().build() ;
			user.setIdUser(id);
			userService.save(user);
			return ResponseEntity.noContent().build();

	 }
	 @DeleteMapping("/deleteUser/{id}")
	 public void deleteUser(@PathVariable("id") Long id)
	 {
		 userService.deleteById(id);
	 }
	 @DeleteMapping("/deleteAllUser")
	 public void deleteAllUser()
	 {
		 userService.deleteAll();
	 }
	 

}
