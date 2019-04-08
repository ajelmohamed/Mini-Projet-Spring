package com.example.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Categorie;
import com.example.Model.Post;
import com.example.Service.PostService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4300"})
public class PostController {
	@Autowired 
	 PostService postService;
	 
	 @PostMapping("/savePost")
	 public void  savePost(@RequestBody Post post)
	 {   System.out.println(post.toString());
		 postService.save(post);
	 }
	 
	 @GetMapping("/findPost/{id}")
	 public Optional<Post> findPost(@PathVariable("id") String id)
	 {   System.out.println(id);
		 return postService.findById(id);
	 }
	 
	 
	 @GetMapping("/findAllPost")
	 public Iterable<Post> findAllPost()
	 {
		 return postService.findAll();
	 }
	 @PutMapping("/updatePost")
	 public  ResponseEntity<Post> updatePost(@RequestBody Post post )
	 {
			Optional<Post> postOptional=postService.findById(post.getIdPost());
			if (!postOptional.isPresent())
				return  ResponseEntity.notFound().build() ;
			post.setIdPost(post.getIdPost());
			postService.save(post);
			return new ResponseEntity<Post>(post,HttpStatus.OK);

	 }
	 
	 @GetMapping("/findpostParCategorie/{id}")
	 public Iterable<Post> findAllPostParCategorie(@PathVariable("id") String categorie){
		 System.out.println(categorie.toString());
		 return postService.findPostCategorie(categorie);
	 }
	 
	 @DeleteMapping("/deletePost/{id}")
	 public void deletePost(@PathVariable("id") String id)
	 {
		 postService.deleteById(id);
	 }
	 @DeleteMapping("/deleteAllPost")
	 public void deleteAllPost()
	 {
		 postService.deleteAll();
	 }
	 

}
