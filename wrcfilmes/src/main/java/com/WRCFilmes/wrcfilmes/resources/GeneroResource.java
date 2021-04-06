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
import com.WRCFilmes.wrcfilmes.models.Genero;
import com.WRCFilmes.wrcfilmes.repositories.FilmesRepositorio;
import com.WRCFilmes.wrcfilmes.repositories.GeneroRepositorio;

@RestController
@RequestMapping(path="/genero")
public class GeneroResource {

	private GeneroRepositorio generoRepositorio;
	public GeneroResource(GeneroRepositorio generoRepositorio) {
		super();
		this.generoRepositorio = generoRepositorio;
		}
	
	@PostMapping(path="/adicionar")
	public ResponseEntity<Genero> save(@RequestBody Genero genero){
		generoRepositorio.save(genero);
		return new ResponseEntity<>(genero, HttpStatus.OK);
		}
	
	@GetMapping(path="/listar")
	public ResponseEntity<List<Genero>> getAll(){
		List<Genero> genero = new ArrayList<>();
		genero = generoRepositorio.findAll();
		return new ResponseEntity<>(genero, HttpStatus.OK);
		}
	
	//BUSCA POR ID
	@GetMapping(path="/pesquisarporid/{id}")
	public ResponseEntity<Optional<Genero>> getById(@PathVariable Integer id) {
		Optional<Genero> genero;
		try {
			genero = generoRepositorio.findById(id);
			return new ResponseEntity<Optional<Genero>>(genero, HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Genero>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/deletarporid/{id}")
	public ResponseEntity<Optional<Genero>> deleteById(@PathVariable Integer id) {
		try {
			generoRepositorio.deleteById(id);
			return new ResponseEntity<Optional<Genero>>(HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Genero>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/editarporid/{id}")
	public ResponseEntity<Genero> update(@PathVariable Integer id, @RequestBody Genero newGenero){
		return generoRepositorio.findById(id)
				.map(genero -> {
					genero.setGenero(newGenero.getGenero());
					genero.setDuracao(newGenero.getDuracao());
					genero.setLiberacaoidade(newGenero.getLiberacaoidade());
					genero.setElenco(newGenero.getElenco());
					Genero generoUpdate = generoRepositorio.save(genero);
					return ResponseEntity.ok().body(generoUpdate);
				}).orElse(ResponseEntity.notFound().build());
	}
}
