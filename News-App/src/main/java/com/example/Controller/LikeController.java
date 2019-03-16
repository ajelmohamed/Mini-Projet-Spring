package com.example.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Like;
import com.example.Service.LikeService;

@RestController(value="/likes")
public class LikeController {
	@Autowired 
	 LikeService likeService;
	 
	 @PostMapping("/saveLike")
	 public void  saveLike(@RequestBody Like like)
	 {
		 likeService.save(like);
	 }
	 
	 @GetMapping("/findLike/{id}")
	 public Optional<Like> findLike(@PathVariable("id") String id)
	 {
		 return likeService.findById(id);
	 }
	 
	 
	 @GetMapping("/findAllLike")
	 public Iterable<Like> findAllLike()
	 {
		 return likeService.findAll();
	 }
	 @PutMapping("/updateLike/{id}")
	 public  ResponseEntity<Object> updateLike(@RequestBody Like like ,@PathVariable("id") String id)
	 {
			Optional<Like> likeOptional=likeService.findById(id);
			if (!likeOptional.isPresent())
				return  ResponseEntity.notFound().build() ;
			like.setIdLike(id);
			likeService.save(like);
			return ResponseEntity.noContent().build();

	 }
	 @DeleteMapping("/deleteLike/{id}")
	 public void deleteLike(@PathVariable("id") String id)
	 {
		 likeService.deleteById(id);
	 }
	 @DeleteMapping("/deleteAllLike")
	 public void deleteAllLike()
	 {
		 likeService.deleteAll();
	 }
	 

}
