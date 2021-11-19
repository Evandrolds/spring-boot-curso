
package com.curso.springboot.resources;

import com.curso.springboot.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Evandro
 */
// avisando o tipo da aplicação q será usada
@RestController
// aplicando um mapeamento
@RequestMapping(value = "/users")
public class UserResource {
    //metodo que respondo a requissição do HTTP
    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Sandro", "sandro@gmail.com", "1234");
        return ResponseEntity.ok().body(user);
    }
}
