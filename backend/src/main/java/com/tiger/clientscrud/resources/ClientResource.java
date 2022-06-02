package com.tiger.clientscrud.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.clientscrud.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> clients = new ArrayList<>();
		Instant birthDate1 = Instant.parse("1985-03-19T00:00:00Z");
		Instant birthDate2 = Instant.parse("1983-06-25T00:00:00Z");
		clients.add(new Client(1L, "Geremias", "002.287.524-13", 1200.00, birthDate1, 2));
		clients.add(new Client(2L, "Maria", "002.248.514-97", 2500.00, birthDate2, 1));
		return ResponseEntity.ok().body(clients);
 	}
}
