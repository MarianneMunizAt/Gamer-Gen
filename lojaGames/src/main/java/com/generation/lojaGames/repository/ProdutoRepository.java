package com.generation.lojaGames.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.generation.lojaGames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	//ACHAR POR TITULO
		public List<Produto> findAllByTituloContainingIgnoreCase(@Param ("titulo") String titulo);
		
		public List<Produto> findAllByLancamento (@Param ("lancamento") Date lancamento);

}
