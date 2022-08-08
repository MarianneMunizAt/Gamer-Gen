package com.generation.lojaGames.controller;

import java.util.Date;
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

import com.generation.lojaGames.model.Produto;
import com.generation.lojaGames.repository.ProdutoRepository;


@RestController
@RequestMapping("/produto")
@CrossOrigin(origins =  "*", allowedHeaders = "*")

public class ProdutoController {

	
	
	
	//CLASSE DE REPOSITORIO PRODUTO
	
		@Autowired
		private ProdutoRepository repository;
		
	// METODO
		
		@GetMapping
		public ResponseEntity<List<Produto>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
	//ACHAR ALGO PELO ID
		
		@GetMapping("/{id}")
		public ResponseEntity<Produto> GetById(@PathVariable Long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		
		//ACHAR ALGO PELO TITULO	
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List <Produto>> GetByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		}
		
		
		//ACHAR ALGO PELA DATA DE LANÇAMENTO	
		
			@GetMapping("/lancamento/{lancamento}")
			public ResponseEntity<List <Produto>> GetByLancamento(@PathVariable Date lancamento){
			return ResponseEntity.ok(repository.findAllByLancamento(lancamento));
				}
		
		
		
		
		
		//POST
		
		@PostMapping					 // @Valid
		public ResponseEntity<Produto> post (@RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		}
		
		//PUT - AQUI É PRA ATUALIZAR UM DADO JÁ COLOCADO COM O 'POST' (SEMPRE LEMBRAR DE COLOCAR O id QUANDO FOR ATUALIZAR, SEN VAI COMO UM DADO NOVO)
		
		@PutMapping
		public ResponseEntity<Produto> put (@RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
		}
		
		//DELETE
		
		@DeleteMapping ("/{id}")
		public void delete (@PathVariable Long id){
			repository.deleteById(id);
		}
}
