package com.orangebank.orange.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangebank.orange.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findAllByOrderByNameAsc();
}
