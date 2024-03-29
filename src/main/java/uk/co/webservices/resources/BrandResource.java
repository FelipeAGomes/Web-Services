package uk.co.webservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.webservices.entities.Brand;
import uk.co.webservices.services.BrandService;

@RestController
@RequestMapping(value = "/brands")
public class BrandResource { // depend of user1service	
	
	@Autowired
	private BrandService service;
	
	@GetMapping
	public ResponseEntity<List<Brand>> findAll(){
		List<Brand> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Brand> findById(@PathVariable Long id){
		Brand obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
