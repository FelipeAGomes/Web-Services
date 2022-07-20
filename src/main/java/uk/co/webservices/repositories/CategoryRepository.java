package uk.co.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.webservices.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
