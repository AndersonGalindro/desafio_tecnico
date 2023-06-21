package com.elotech.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Generated
//@Builder
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@NotEmpty(message = "nome não pode ser null ou vazio")
	String nome;

	@NotEmpty(message = "cpf  não pode ser null ou vazio")
	@CPF(message = "cpf inválido")
	@Column(unique = true)
	String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@PastOrPresent(message = "Data precisa ser anterior ou igual a hoje")
	@NotNull(message = "data_nascimento não pode ser null ou vazio")
	@JsonProperty("data_nascimento")
	LocalDate dataNascimento;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id", referencedColumnName = "id")
	@NotEmpty(message = "Contato não pode ser null ou vazio")
	List<Contato> contato;

}
