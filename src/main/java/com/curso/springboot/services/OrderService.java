
package com.curso.springboot.services;

import com.curso.springboot.entities.Order;
import com.curso.springboot.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Evandro
 */
@Service
public class OrderService{
    
    @Autowired
    private OrderRepository orderReposirory;
    
    public List<Order> findAll(){
       return orderReposirory.findAll();
    }
    public Order findById(Long id){
        Optional<Order> or = orderReposirory.findById(id);
        return or.get();
    }
}
