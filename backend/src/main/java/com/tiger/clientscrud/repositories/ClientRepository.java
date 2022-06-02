package com.tiger.clientscrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiger.clientscrud.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
