package uk.co.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.webservices.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
