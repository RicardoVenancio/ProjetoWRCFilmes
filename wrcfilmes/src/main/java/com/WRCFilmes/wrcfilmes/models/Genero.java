package com.WRCFilmes.wrcfilmes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genero {
	@GeneratedValue
	@Id
	private int id;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "duracao")
	private int duracao;
	
	@Column(name = "idade")
	private int liberacaoidade;
	
	@Column(name = "elenco")
	private String elenco;

	
	////////////////////////////////// GETS E SETS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getLiberacaoidade() {
		return liberacaoidade;
	}

	public void setLiberacaoidade(int liberacaoidade) {
		this.liberacaoidade = liberacaoidade;
	}

	public String getElenco() {
		return elenco;
	}

	public void setElenco(String elenco) {
		this.elenco = elenco;
	}

	
////////////////////////////////// TO STRING
	@Override
	public String toString() {
		return "Genero [id=" + id + ", genero=" + genero + ", duracao=" + duracao + ", liberacaoidade=" + liberacaoidade
				+ ", elenco=" + elenco + "]";
	}

	
////////////////////////////////// HASH CODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((elenco == null) ? 0 : elenco.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + id;
		result = prime * result + liberacaoidade;
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
		Genero other = (Genero) obj;
		if (duracao != other.duracao)
			return false;
		if (elenco == null) {
			if (other.elenco != null)
				return false;
		} else if (!elenco.equals(other.elenco))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id != other.id)
			return false;
		if (liberacaoidade != other.liberacaoidade)
			return false;
		return true;
	}

	
	
////////////////////////////////// CONSTRUCTOR POVOADO
	public Genero(int id, String genero, int duracao, int liberacaoidade, String elenco) {
		super();
		this.id = id;
		this.genero = genero;
		this.duracao = duracao;
		this.liberacaoidade = liberacaoidade;
		this.elenco = elenco;
	}

	
	
////////////////////////////////// CONSTRUCTOR VAZIO
	public Genero() {
		super();
	}
}
