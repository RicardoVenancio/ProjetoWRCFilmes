package com.WRCFilmes.wrcfilmes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filme {
	
	@GeneratedValue
	@Id
	private int id;
	
	@Column(name = "autor")
	private String autor;
	
	@Column(name = "datalancamento")
	private String datalancamento; //TROCAR PARA DATE
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "diretor")
	private String diretor;
	
	@Column(name = "atorprincipal")
	private String atorprincipal;
	
	
////////////////////////////////////// GET  E  SET
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(String datalancamento) {
		this.datalancamento = datalancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getAtorprincipal() {
		return atorprincipal;
	}

	public void setAtorprincipal(String atorprincipal) {
		this.atorprincipal = atorprincipal;
	}

	////////////////////////////////////// TO STRING
	@Override
	public String toString() {
		return "Filme [id=" + id + ", autor=" + autor + ", datalancamento=" + datalancamento + ", genero=" + genero
				+ ", nome=" + nome + ", diretor=" + diretor + ", atorprincipal=" + atorprincipal + "]";
	}
	
	
////////////////////////////////////////// HASH CODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atorprincipal == null) ? 0 : atorprincipal.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((datalancamento == null) ? 0 : datalancamento.hashCode());
		result = prime * result + ((diretor == null) ? 0 : diretor.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (atorprincipal == null) {
			if (other.atorprincipal != null)
				return false;
		} else if (!atorprincipal.equals(other.atorprincipal))
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (datalancamento != other.datalancamento)
			return false;
		if (diretor == null) {
			if (other.diretor != null)
				return false;
		} else if (!diretor.equals(other.diretor))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

////////////////////////////////////// CONSTRUCTOR VAZIO
	public Filme() {

	}

////////////////////////////////////// CONSTRUCTOR POVOADO
	public Filme(int id, String autor, String datalancamento, String genero, String nome, String diretor,
			String atorprincipal) {
		super();
		this.id = id;
		this.autor = autor;
		this.datalancamento = datalancamento;
		this.genero = genero;
		this.nome = nome;
		this.diretor = diretor;
		this.atorprincipal = atorprincipal;
	}
}
