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

import com.WRCFilmes.wrcfilmes.models.Pessoa;
import com.WRCFilmes.wrcfilmes.repositories.PessoasRepositorio;

@RestController
@RequestMapping(path="/pessoas")
public class PessoaResource {

	private PessoasRepositorio pessoasRepositorio;
	public PessoaResource(PessoasRepositorio pessoaRepositorio) {
		super();
		this.pessoasRepositorio = pessoaRepositorio;
		}
	
	@PostMapping(path = "/adicionar")
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		pessoasRepositorio.save(pessoa);
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
		}
	
	@GetMapping(path="/listar")
	public ResponseEntity<List<Pessoa>> getAll(){
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas = pessoasRepositorio.findAll();
		return new ResponseEntity<>(pessoas, HttpStatus.OK);
		}
	
	//BUSCA POR ID
	@GetMapping(path="/listarporid/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Integer id) {
		Optional<Pessoa> pessoa;
		try {
			pessoa = pessoasRepositorio.findById(id);
			return new ResponseEntity<Optional<Pessoa>>(pessoa, HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/deletarporid/{id}")
	public ResponseEntity<Optional<Pessoa>> deleteById(@PathVariable Integer id) {
		try {
			pessoasRepositorio.deleteById(id);
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/editarpessoa/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Pessoa newPessoa){
		return pessoasRepositorio.findById(id)
				.map(pessoa -> {
					pessoa.setNome(newPessoa.getNome());
					pessoa.setIdade(newPessoa.getIdade());
					pessoa.setSexo(newPessoa.getSexo());
					pessoa.setCpf(newPessoa.getCpf());
					pessoa.setEmail(newPessoa.getEmail());
					pessoa.setSenha(newPessoa.getSenha());
					Pessoa pessoaUpdate = pessoasRepositorio.save(pessoa);
					return ResponseEntity.ok().body(pessoaUpdate);
				}).orElse(ResponseEntity.notFound().build());
	}
	}
