package com.tiger.clientscrud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.clientscrud.dto.ClientDTO;
import com.tiger.clientscrud.entities.Client;
import com.tiger.clientscrud.repositories.ClientRepository;
import com.tiger.clientscrud.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll();
		
		return list.stream()
				.map(x -> new ClientDTO(x))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(
				() -> new ResourceNotFoundException("Cliente não encontrado"));
		return new ClientDTO(entity);
	}
}
