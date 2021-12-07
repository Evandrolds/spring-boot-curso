package com.curso.springboot.resources;

import com.curso.springboot.entities.Order;
import com.curso.springboot.services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Evandro
 */
// avisando o tipo da aplicação q será usada
@RestController                    // aplicando um mapeamento                 
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired // informando ao spring para fazer a INJEÇÃO DE DEPENDENCIA
    private OrderService orderService;

    //metodo que respondo a requissição do HTTP
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //paramentro que será usado na requisição HTTP do postman
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order or = orderService.findById(id);
        return ResponseEntity.ok().body(or);
    }
}
