package com.generation.lojaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojaGames.model.Categoria;
import com.generation.lojaGames.repository.CategoriaRepository;

@RestController
@CrossOrigin (origins =  "*", allowedHeaders = "*")
@RequestMapping ("/categoria")

public class CategoriaController {

	
	
	//CLASSE DE REPOSITORIO CATEGORIA
	
		@Autowired
		private CategoriaRepository repository;
		
		// METODO
		
		@GetMapping
		public ResponseEntity<List<Categoria>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
	//ACHAR ALGO PELO ID
		
		@GetMapping ("/{id}")
		public ResponseEntity<Categoria> getById(@PathVariable Long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		

	// ACHAR PELAS CARACTERISTICAS
		
		@GetMapping("/caracteristicas/{caracteristicas}")
		public ResponseEntity<List<Categoria>> getByName(@PathVariable String caracteristicas){
			return ResponseEntity.ok(repository.findAllByCaracteristicasContainingIgnoreCase(caracteristicas));
		}
		

		
		
		
	//POST
		
		
		@PostMapping
		public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(repository.save(categoria));
		}
		
	// PUT
		
		@PutMapping
		public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
			return ResponseEntity.ok(repository.save(categoria));
		}
		
	//DELETE 
		
		@DeleteMapping("/{id}")
		public void delete (@PathVariable Long id) {
			repository.deleteById(id);
		}
}
