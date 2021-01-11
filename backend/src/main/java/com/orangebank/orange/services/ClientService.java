package com.orangebank.orange.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orangebank.orange.dto.ClientDTO;
import com.orangebank.orange.entities.Client;
import com.orangebank.orange.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client(null, dto.getName(), dto.getEmail(), dto.getCpf(), dto.getBirthDate());
		client = repository.save(client);
		return new ClientDTO(client);
	}
}
