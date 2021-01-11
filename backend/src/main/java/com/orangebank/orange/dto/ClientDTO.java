package com.orangebank.orange.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.orangebank.orange.entities.Client;

public class ClientDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email(message="E-mail inválido!")
	private String email;
	
	@NotBlank
	@CPF(message="CPF inválido!")
	private String cpf;
	
	@NotBlank
	private String birthDate;
	
	public ClientDTO() {
		
	}

	public ClientDTO(Long id, String name, String email, String cpf, String birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}
	
	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cpf = entity.getCpf();
		birthDate = entity.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
}
