package com.example.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Model.Admin;
import com.example.Model.Post;
import com.example.Model.User;
import com.example.Service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	 
	 
	 @JsonIgnore
	 @RequestMapping(value = "/registerUser", method = RequestMethod.POST, headers = {"content-type=multipart/mixed", "content-type=multipart/form-data"},consumes = {"multipart/form-data"})
		 public ResponseEntity<User>  registerUser(@RequestPart(required=false,name="image") MultipartFile file,@RequestPart(name="user")String struser) throws IOException
	{ 		
		User user = new ObjectMapper().readValue(struser, User.class);
		 user.setAvatarUser(file.getBytes());
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
	 
	 /*****************************************photo post******************************************/
		@GetMapping("/photoUser/{id}")
	    public  byte[] photoPersonne(@PathVariable("id") String id, HttpServletRequest request) {
	     
			Optional<User> p=userService.findById(id);
			
			User p1=p.get();
			try {
				if(p1.getAvatarUser()==null) {
					return null;
					}
				return IOUtils.toByteArray(new ByteArrayInputStream(p1.getAvatarUser()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	 

}
