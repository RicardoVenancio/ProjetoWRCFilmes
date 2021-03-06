package com.WRCFilmes.wrcfilmes.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WRCFilmes.wrcfilmes.models.Filme;
import com.WRCFilmes.wrcfilmes.repositories.FilmesRepositorio;

@RestController
@RequestMapping(path="/filmes")
public class FilmeResource {

	private FilmesRepositorio filmesRepositorio;
	public FilmeResource(FilmesRepositorio filmesRepositorio) {
		super();
		this.filmesRepositorio = filmesRepositorio;
		}
	
	@PostMapping(path="/adicionar")
	public ResponseEntity<Filme> save(@RequestBody Filme filme){
		filmesRepositorio.save(filme);
		return new ResponseEntity<>(filme, HttpStatus.OK);
		}
	
	@GetMapping(path="/listar")
	public ResponseEntity<List<Filme>> getAll(){
		List<Filme> filmes = new ArrayList<>();
		filmes = filmesRepositorio.findAll();
		return new ResponseEntity<>(filmes, HttpStatus.OK);
		}
	
	//BUSCA POR ID
	@GetMapping(path="/pesquisarporid/{id}")
	public ResponseEntity<Optional<Filme>> getById(@PathVariable Integer id) {
		Optional<Filme> filme;
		try {
			filme = filmesRepositorio.findById(id);
			return new ResponseEntity<Optional<Filme>>(filme, HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Filme>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/deletarporid/{id}")
	public ResponseEntity<Optional<Filme>> deleteById(@PathVariable Integer id) {
		try {
			filmesRepositorio.deleteById(id);
			return new ResponseEntity<Optional<Filme>>(HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Filme>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/editarporid/{id}")
	public ResponseEntity<Filme> update(@PathVariable Integer id, @RequestBody Filme newFilme){
		return filmesRepositorio.findById(id)
				.map(filme -> {
					filme.setAutor(newFilme.getAutor());
					filme.setDatalancamento(newFilme.getDatalancamento());
					filme.setGenero(newFilme.getGenero());
					filme.setNome(newFilme.getNome());
					filme.setDiretor(newFilme.getDiretor());
					filme.setAtorprincipal(newFilme.getAtorprincipal());
					Filme filmeUpdate = filmesRepositorio.save(filme);
					return ResponseEntity.ok().body(filmeUpdate);
				}).orElse(ResponseEntity.notFound().build());
	}
}
