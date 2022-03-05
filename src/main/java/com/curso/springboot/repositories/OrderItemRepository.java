package com.curso.springboot.repositories;

import com.curso.springboot.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Evandro
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
