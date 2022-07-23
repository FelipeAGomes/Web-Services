package uk.co.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.webservices.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
