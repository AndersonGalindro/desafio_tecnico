package com.elotech.mock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import com.elotech.entity.Pessoa;

public class PessoaMock {

	public Pessoa pessoaSaveBuilde() {
		
		ContatoMock contatoMock = new ContatoMock();
		Pessoa pessoa = new Pessoa();
		
		pessoa.setContato(List.of(contatoMock.contatoBuilder()));
		pessoa.setCpf("10363142436");
		pessoa.setDataNascimento(LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("d/MM/uuuu")),
				DateTimeFormatter.ofPattern("d/MM/uuuu")));
		pessoa.setNome("Anderson");
		
		return pessoa;
	}

	public Pessoa pessoaPutBuilde() {
		
		ContatoMock contatoMock = new ContatoMock();
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(new Random().nextInt());
		pessoa.setContato(List.of(contatoMock.contatoBuilder()));
		pessoa.setCpf("10363142436");
		pessoa.setDataNascimento(LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("d/MM/uuuu")),
				DateTimeFormatter.ofPattern("d/MM/uuuu")));
		pessoa.setNome("Anderson");
		
		return pessoa;
	}

}
