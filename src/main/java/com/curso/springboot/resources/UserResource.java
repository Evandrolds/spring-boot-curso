package com.curso.springboot.resources;

import com.curso.springboot.entities.User;
import com.curso.springboot.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired // informando ao spring para fazer a INJEÇÃO DE DEPENDENCIA
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
       
        return ResponseEntity.ok(userService.insert(user));
    }
    //metodo que respondo a requissição do HTTP
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}") //paramentro que será usado na requisição HTTP do postman
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build(); // em caso de resposta vaizia (VOID) usa-se no noContent()
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User user){
      user = userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }
}
