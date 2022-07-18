package uk.co.webservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.webservices.entities.User1;
import uk.co.webservices.services.User1Service;

@RestController
@RequestMapping(value = "/users")
public class User1Resource { // depend of user1service	
	
	@Autowired
	private User1Service service;
	
	@GetMapping
	public ResponseEntity<List<User1>> findAll(){
		List<User1> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User1> findById(@PathVariable Long id){
		User1 obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
