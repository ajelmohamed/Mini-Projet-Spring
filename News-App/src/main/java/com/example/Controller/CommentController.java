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

import com.example.Model.Comment;
import com.example.Service.CommentService;

@RestController
public class CommentController {
	@Autowired 
	 CommentService commentService;
	 
	 @PostMapping("/saveComment")
	 public void  saveComment(@RequestBody Comment comment)
	 {
		 commentService.save(comment);
	 }
	 
	 @GetMapping("/findComment/{id}")
	 public Optional<Comment> findComment(@PathVariable("id") Long id)
	 {
		 return commentService.findById(id);
	 }
	 
	 
	 @GetMapping("/findAllComment")
	 public Iterable<Comment> findAllComment()
	 {
		 return commentService.findAll();
	 }
	 @PutMapping("/updateComment/{id}")
	 public  ResponseEntity<Object> updateComment(@RequestBody Comment comment ,@PathVariable("id") Long id)
	 {
			Optional<Comment> commentOptional=commentService.findById(id);
			if (!commentOptional.isPresent())
				return  ResponseEntity.notFound().build() ;
			comment.setIdComment(id);
			commentService.save(comment);
			return ResponseEntity.noContent().build();

	 }
	 @DeleteMapping("/deleteComment/{id}")
	 public void deleteComment(@PathVariable("id") Long id)
	 {
		 commentService.deleteById(id);
	 }
	 @DeleteMapping("/deleteAllComment")
	 public void deleteAllComment()
	 {
		 commentService.deleteAll();
	 }
	 

}
