package com.WRCFilmes.wrcfilmes.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	@Id
	private String nomerole;
	
	@ManyToMany
	private List<Usuario> usuarios;
	
	public String getNomerole() {
		return nomerole;
	}



	public void setNomerole(String nomerole) {
		this.nomerole = nomerole;
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nomerole;
	}

}
