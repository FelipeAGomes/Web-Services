package uk.co.webservices.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import uk.co.webservices.entities.Product;
import uk.co.webservices.repositories.ProductRepository;
import uk.co.webservices.services.exceptions.DatabaseException;
import uk.co.webservices.services.exceptions.ResourceNotFoundException;

@Service // to use autowired 
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
	public Product insert (Product obj) {
		return productRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	public Product update(Long id, Product obj) {
		try {
		Product entity = productRepository.getOne(id);
		updateData(entity, obj);
		return productRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product obj) {
		entity.setBrand(obj.getBrand());
		entity.getCategories();
		entity.setDescription(obj.getDescription());
		entity.setImgUrl(obj.getImgUrl());
		entity.setName(obj.getName());
		entity.setPrice(obj.getPrice());
	}
}
