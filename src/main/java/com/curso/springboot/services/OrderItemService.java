package com.curso.springboot.services;

import com.curso.springboot.entities.Order;
import com.curso.springboot.entities.OrderItem;
import com.curso.springboot.repositories.OrderItemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Evandro
 */
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemReposirory;
    
    public List<OrderItem> findAll(){
       return orderItemReposirory.findAll();
    }
    public OrderItem findById(Long id){
        Optional<OrderItem> or = orderItemReposirory.findById(id);
        return or.get();
    }
}
