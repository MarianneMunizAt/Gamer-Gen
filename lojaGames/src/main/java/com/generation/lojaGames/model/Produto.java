package com.generation.lojaGames.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;






@Entity
@Table(name = "tb_produtos") // QUE VAI CRIAR UMA TABELA NO BANCO DE DADOS CHAMADA PRODUTOS GAMER

public class Produto {

	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank
	@Size (min = 5 , max = 100)
	private String titulo;
	
	
	@NotBlank
	@Size (min = 10 , max = 500)
	private String descricao;
	
	
	
//DATA DE LANÇAMENTO	
	@Temporal(TemporalType.TIMESTAMP) //AQUI A PESSOAL TEM QUE INSERIR A DATA, ANO, TEMPO
	@NotNull
// IMPORTAR DATE "java.util'
	private Date lancamento = new java.sql.Date(System.currentTimeMillis());
	
	
	
//DATA DE CADATRO OU PODE SER DE PESQUISA NA LOJA
	
	@UpdateTimestamp					//FORMA CERTA DE COLOCAR TEMPO - VAI AUTOMATICO, A PESSOA NÃO PRECISA ESCREVER
	private LocalDateTime data;

	
	//RELACIONAMENTO COM CATEGORIA
	//MUITOS PARA UM
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;
	
	
	//GETTERS AND SETTERS
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getLancamento() {
		return lancamento;
	}

	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
