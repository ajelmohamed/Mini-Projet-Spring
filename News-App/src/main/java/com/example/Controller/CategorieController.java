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

import com.example.Model.Categorie;
import com.example.Service.CategorieService;


@RestController
public class CategorieController {
	@Autowired 
	 CategorieService categorieService;
	 
	 @PostMapping("/saveCategorie")
	 public void  saveCategorie(@RequestBody Categorie categorie)
	 {
		 categorieService.save(categorie);
	 }
	 
	 @GetMapping("/findCategorie/{id}")
	 public Optional<Categorie> findCategorie(@PathVariable("id") Long id)
	 {
		 return categorieService.findById(id);
	 }
	 
	 
	 @GetMapping("/findAllCategorie")
	 public Iterable<Categorie> findAllCategorie()
	 {
		 return categorieService.findAll();
	 }
	 @PutMapping("/updateCategorie/{id}")
	 public  ResponseEntity<Object> updateCategorie(@RequestBody Categorie categorie ,@PathVariable("id") Long id)
	 {
			Optional<Categorie> categorieOptional=categorieService.findById(id);
			if (!categorieOptional.isPresent())
				return  ResponseEntity.notFound().build() ;
			categorie.setIdCategorie(id);    
			categorieService.save(categorie);
			return ResponseEntity.noContent().build();

	 }
	 @DeleteMapping("/deleteCategorie/{id}")
	 public void deleteCategorie(@PathVariable("id") Long id)
	 {
		 categorieService.deleteById(id);
	 }
	 @DeleteMapping("/deleteAllCategorie")
	 public void deleteAllCategorie()
	 {
		 categorieService.deleteAll();
	 }

}
