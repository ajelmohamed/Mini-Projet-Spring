package com.example.Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;
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

import com.example.Model.Categorie;
import com.example.Model.Post;
import com.example.Service.PostService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4300"})
public class PostController {
	@Autowired 
	 PostService postService;
	 @JsonIgnore
	 @RequestMapping(value = "/savePost", method = RequestMethod.POST, headers = {"content-type=multipart/mixed", "content-type=multipart/form-data"},consumes = {"multipart/form-data"})
	 public void  savePost(@RequestPart(required=false,name="image") MultipartFile file1,@RequestPart(required=false,name="video") MultipartFile file2,@RequestPart(name="post")String strpost) throws IOException
	 {
		 Post post = new ObjectMapper().readValue(strpost, Post.class);
		 if(file1!=null)
		 {
		 post.setPhotoPost(file1.getBytes());
		 }
		 if(file2!=null)
		 {	 
		 post.setVideoPost(file2.getBytes());
		 }
		 postService.save(post);
	 }
	 @JsonIgnore
	 @RequestMapping(value = "/updatePostt/{id}", method = RequestMethod.PUT, headers = {"content-type=multipart/mixed", "content-type=multipart/form-data"},consumes = {"multipart/form-data"})
     public  void updatePostt(@PathVariable("id") String id,@RequestPart(required=false,name="image") MultipartFile file1,@RequestPart(required=false,name="video") MultipartFile file2,@RequestPart(name="post")String strpost) throws IOException
	 {       
		    Post post = new ObjectMapper().readValue(strpost, Post.class);
			Optional<Post> postOptional=postService.findById(id);
			Post p1=postOptional.get();
			if(post.getTitlePost()!=null)
				p1.setTitlePost(post.getTitlePost());
			if(post.getContenuePost()!=null)
				p1.setContenuePost(post.getContenuePost());
			p1.setDatePost(post.getDatePost());
			if(post.getAdmin()!=null)
				p1.setAdmin(post.getAdmin());
			if(post.getCategoriePost()!=null)
				p1.setCategoriePost(post.getCategoriePost());
			if(file1 !=null)
				p1.setPhotoPost(file1.getBytes());
			if(file2 !=null)
				p1.setVideoPost(file2.getBytes());
		    postService.save(p1);

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
	 @PutMapping("/updatePost/{id}")
	 public  ResponseEntity<Object> updatePost(@RequestBody Post post ,@PathVariable("id") String id)
	 {
			Optional<Post> postOptional=postService.findById(id);
			if (!postOptional.isPresent())
				return  ResponseEntity.notFound().build() ;
			post.setIdPost(id);
			postService.save(post);
			return ResponseEntity.noContent().build();

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
	 
	 private byte[] getStaticImage(String fileName, HttpServletRequest request) throws Exception {
			File file = new File(request.getSession().getServletContext().getRealPath("/resources/img/" + fileName));
			BufferedImage img = ImageIO.read(file);
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(img, "png", arrayOutputStream);
			arrayOutputStream.flush();
			return arrayOutputStream.toByteArray();
		}
/*****************************************photo post******************************************/
		@GetMapping("/photoPost/{id}")
	    public  byte[] photoPersonne(@PathVariable("id") String id, HttpServletRequest request) {
	     
			Optional<Post> p=postService.findById(id);
			
			Post p1=p.get();
			try {
				if(p1.getPhotoPost()==null) {
					return null;
					}
				return IOUtils.toByteArray(new ByteArrayInputStream(p1.getPhotoPost()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		/*****************************************video post******************************************/
		@GetMapping("/videoPost/{id}")
	    public  byte[] videoPersonne(@PathVariable("id") String id, HttpServletRequest request) {
	     
			Optional<Post> p=postService.findById(id);
			Post p1=p.get();
			try {
				if(p1.getVideoPost()==null) {
					return null;
					}
				return IOUtils.toByteArray(new ByteArrayInputStream(p1.getVideoPost()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	

}
