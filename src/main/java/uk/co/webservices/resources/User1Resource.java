package uk.co.webservices.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.webservices.entities.User1;

@RestController
@RequestMapping(value = "/users")
public class User1Resource {
	
	@GetMapping
	public ResponseEntity<User1> findAll(){
		User1 u = new User1(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
