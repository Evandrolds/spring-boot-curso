
package com.curso.springboot.services;

import com.curso.springboot.entity.User;
import com.curso.springboot.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Evandro
 */
@Service
public class UserService {
    @Autowired  // Para o spring fazer a INJEÇÃO DE DEPENDENCIA
    private UserRepository repository;
    

    public List<User> findAll(){
        return repository.findAll();
    }
    
    public User findById(long id){
        Optional<User> user = repository.findById(id);
        return user.get();
    }
}
