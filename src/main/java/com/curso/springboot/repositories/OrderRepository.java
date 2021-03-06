package com.curso.springboot.repositories;

import com.curso.springboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Evandro
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
