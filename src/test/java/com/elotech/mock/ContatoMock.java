package com.elotech.mock;

import java.util.Random;

import com.elotech.entity.Contato;

public class ContatoMock {

	public Contato contatoBuilder() {
		Contato contato = new Contato();

		contato.setEmail("AndersonGalindro@hotmail.com");
		contato.setId(new Random().nextInt());
		contato.setNome("Anderson");
		contato.setTelefone("891996828761");

		return contato;
	}
}
