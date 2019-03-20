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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.User;
import com.example.Service.UserService;

@RestController()
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4300"})

public class UserController {
	@Autowired 
	 UserService userService;
	
	 @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	 public ResponseEntity<User>  login(@RequestParam(required=false,name="email") String email,@RequestParam(required=false,name="password") String password)
	 {   		

		 return userService.loginUser(email,password);
	 }
	 
	 
	 @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	 public ResponseEntity<User>  registerUser(@RequestBody User user)
	 {
		return userService.registerUser(user);
	 }
	 
	 @GetMapping("/findUser/{id}")
	 public Optional<User> findUser(@PathVariable("id") String id)
	 {
		 return userService.findById(id);
	 }
	 
	 
	 @GetMapping("/findAllUser")
	 public Iterable<User> findAllUser()
	 {
		 return userService.findAll();
	 }
	 @PutMapping("/updateUser/{id}")
	 public  ResponseEntity<Object> updateUser(@RequestBody User user ,@PathVariable("id") String id)
	 {
			Optional<User> userOptional=userService.findById(id);
			if (!userOptional.isPresent())
				return  ResponseEntity.notFound().build() ;
			user.setIdUser(id);
			userService.save(user);
			return ResponseEntity.noContent().build();

	 }
	 @DeleteMapping("/deleteUser/{id}")
	 public void deleteUser(@PathVariable("id") String id)
	 {
		 userService.deleteById(id);
	 }
	 @DeleteMapping("/deleteAllUser")
	 public void deleteAllUser()
	 {
		 userService.deleteAll();
	 }
	 

}
