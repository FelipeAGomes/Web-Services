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
	
	public User1 insert (User1 obj) {
		return user1Repository.save(obj);
	}
	
	public void delete(Long id) {
		user1Repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public User1 update(Long id, User1 obj) {
		User1 entity = user1Repository.getOne(id);
		updateData(entity, obj);
		return user1Repository.save(entity);
	}

	private void updateData(User1 entity, User1 obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
