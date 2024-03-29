package uk.co.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.webservices.entities.Brand;
import uk.co.webservices.repositories.BrandRepository;

@Service // to use autowired 
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	public List<Brand> findAll(){
		return brandRepository.findAll();
	}
	
	public Brand findById(Long id) {
		Optional<Brand> obj = brandRepository.findById(id);
		return obj.get();
	}
}
