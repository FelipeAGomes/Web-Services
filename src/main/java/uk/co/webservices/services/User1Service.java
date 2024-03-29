package uk.co.webservices.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import uk.co.webservices.entities.User1;
import uk.co.webservices.repositories.User1Repository;
import uk.co.webservices.services.exceptions.DatabaseException;
import uk.co.webservices.services.exceptions.ResourceNotFoundException;

@Service // to use autowired 
public class User1Service {

	@Autowired
	private User1Repository user1Repository;
	
	public List<User1> findAll(){
		return user1Repository.findAll();
	}
	
	public User1 findById(Long id) {
		Optional<User1> obj = user1Repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User1 insert (User1 obj) {
		return user1Repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		user1Repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	public User1 update(Long id, User1 obj) {
		try {
		User1 entity = user1Repository.getOne(id);
		updateData(entity, obj);
		return user1Repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User1 entity, User1 obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
