package uk.co.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.webservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	

}
