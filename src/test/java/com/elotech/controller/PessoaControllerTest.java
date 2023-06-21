package com.elotech.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.elotech.mock.PessoaMock;
import com.elotech.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class PessoaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PessoaController pessoaController;

	@MockBean
	PessoaService pessoaService;

	@Autowired
	private ObjectMapper objectMapper;

	PessoaMock pessoa = new PessoaMock();

	@Test
	void testSave() throws Exception {

		ResultActions response = mockMvc
				.perform(post("/pessoa").contentType("application/json")
						.content(objectMapper.writeValueAsString(pessoa.pessoaSaveBuilde())))
				.andExpect(status().isOk());

		assertEquals(response.andReturn().getResponse().getStatus(), HttpStatus.OK.value());

	}

	@Test
	void testFindByNomeContainingOrCpf() throws Exception {

		ResultActions response = mockMvc.perform(get("/pessoa?nome=Anderson").contentType("application/json"))
				.andExpect(status().isOk());

		assertEquals(response.andReturn().getResponse().getStatus(), HttpStatus.OK.value());

	}

	@Test
	void testFindById() throws Exception {

		ResultActions response = mockMvc.perform(get("/pessoa/1").contentType("application/json"))
				.andExpect(status().isOk());

		assertEquals(response.andReturn().getResponse().getStatus(), HttpStatus.OK.value());

	}

	@Test
	void testDeleteById() throws Exception {

		ResultActions response = mockMvc.perform(delete("/pessoa/1").contentType("application/json"))
				.andExpect(status().isOk());

		assertEquals(response.andReturn().getResponse().getStatus(), HttpStatus.OK.value());

	}

	@Test
	void testPut() throws Exception {

		ResultActions responde = mockMvc.perform(put("/pessoa/1").contentType("application/json")
				.content(objectMapper.writeValueAsString(pessoa.pessoaPutBuilde()))).andExpect(status().isOk());

		assertEquals(responde.andReturn().getResponse().getStatus(), HttpStatus.OK.value());

	}

}
