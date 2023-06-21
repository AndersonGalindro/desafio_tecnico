package com.elotech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;

import com.elotech.controller.PessoaController;
import com.elotech.entity.Pessoa;
import com.elotech.mock.PessoaMock;
import com.elotech.repository.PessoaRepository;

@SuppressWarnings("unchecked")
@WebMvcTest(PessoaService.class)
class PessoaServiceTest {

	@MockBean
	PessoaController pessoaController;

	@Autowired
	PessoaService pessoaService;

	@MockBean
	PessoaRepository pessoaRepository;

	@MockBean
	Pessoa pessoa;

	PessoaMock pessoaMock = new PessoaMock();

	@Test
	void testSave() {

		when(pessoaRepository.save(pessoaMock.pessoaSaveBuilde())).thenReturn(pessoaMock.pessoaSaveBuilde());

		assertEquals(pessoaService.save(null, pessoaMock.pessoaSaveBuilde()).getStatusCode(), HttpStatus.CREATED);

	}

	@Test
	void testPut() {

		when(pessoaRepository.save(pessoaMock.pessoaSaveBuilde())).thenReturn(pessoaMock.pessoaSaveBuilde());

		assertEquals(pessoaService.save(new Random().nextInt(), pessoaMock.pessoaSaveBuilde()).getStatusCode(),
				HttpStatus.OK);

	}

	@Test
	void testFindById() {

		when(pessoaRepository.findById(new Random().nextInt()))
				.thenReturn(Optional.ofNullable(pessoaMock.pessoaPutBuilde()));

		assertEquals(pessoaService.findById(new Random().nextInt()).getStatusCode(), HttpStatus.OK);
	}

	@Test
	void testFindByNomeContainingOrCpf() {

		Mockito.when(this.pessoaRepository.findByNomeContainingOrCpf("Anderson", "10363142436", PageRequest.of(0, 1)))
				.thenReturn(Mockito.mock(Page.class));

		assertEquals(pessoaService.findByNomeContainingOrCpf("Anderson Galindro", "10363142436", 0, 1).getStatusCode(),
				HttpStatus.OK);

	}

	@Test
	void testDeleteById() {

		pessoaController.deleteById(new Random().nextInt());

	}

}
