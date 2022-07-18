package uk.co.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.webservices.entities.User1;
import uk.co.webservices.repositories.User1Repository;

@Service // to use autowired 
public class User1Service {

	@Autowired
	private User1Repository user1Repository;
	
	public List<User1> findAll(){
		return user1Repository.findAll();
	}
	
	public User1 findById(Long id) {
		Optional<User1> obj = user1Repository.findById(id);
		return obj.get();
	}
}
