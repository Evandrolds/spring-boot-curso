package com.curso.springboot.services;

import com.curso.springboot.entity.Order;
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
public class OrderService {

    @Autowired  // Para o spring fazer a INJEÇÃO DE DEPENDENCIA
    private OrderRepository ordePepository;

    public List<Order> findAll() {
        return ordePepository.findAll();
    }

    public Order findById(long id) {
        Optional<Order> order = ordePepository.findById(id);
        return order.get();
    }
}
