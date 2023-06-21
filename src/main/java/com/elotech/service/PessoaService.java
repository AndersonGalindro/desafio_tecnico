package com.elotech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elotech.entity.Pessoa;
import com.elotech.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public ResponseEntity<?> save(Integer id, Pessoa pessoa) {
		pessoa.setId(id);
		return new ResponseEntity<>(pessoaRepository.save(pessoa), id == null ? HttpStatus.CREATED : HttpStatus.OK);
	}

	public ResponseEntity<?> findById(Integer id) {
		return new ResponseEntity<>(optionalFindById(id), HttpStatus.OK);
	}

	private Optional<Pessoa> optionalFindById(Integer id) {
		return pessoaRepository.findById(id);
	}

	public ResponseEntity<?> findByNomeContainingOrCpf(String nome, String cpf, Integer page, Integer size) {

		return new ResponseEntity<>(pessoaRepository.findByNomeContainingOrCpf(nome, cpf, PageRequest.of(page, size)),
				HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(Integer id) {

		if (optionalFindById(id).isPresent()) {
			pessoaRepository.deleteById(id);
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Falha ao deletar", HttpStatus.NOT_FOUND);

		}
	}

}
