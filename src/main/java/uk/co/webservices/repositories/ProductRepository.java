package uk.co.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.webservices.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
