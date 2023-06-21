package com.elotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elotech.entity.Pessoa;
import com.elotech.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Pessoa pessoa) {

		return pessoaService.save(null, pessoa);

	}

	@GetMapping
	public ResponseEntity<?> findByNomeContainingOrCpf(@RequestParam(required = false) String nome,
			@RequestParam(required = false) String cpf, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "1") Integer size) {

		return pessoaService.findByNomeContainingOrCpf(nome, cpf, page, size);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {

		return pessoaService.findById(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {

		return pessoaService.deleteById(id);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Integer id, @RequestBody Pessoa pessoa) {

		return pessoaService.save(id, pessoa);

	}

}
