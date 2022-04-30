package com.curso.springboot.services;

import com.curso.springboot.entities.User;
import com.curso.springboot.repositories.UserRepository;
import com.curso.springboot.services.exceptions.DataBaseException;
import com.curso.springboot.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Evandro
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> u =  userRepository.findById(id);
        return u.orElseThrow(()->  new ResourceNotFoundException(id));
    }
    public User insert(User user){
        return userRepository.save(user);
       
    }
    public void deleteById(Long id){
         try{
        userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch( DataIntegrityViolationException e){
           throw new DataBaseException(e.getMessage());// capturando exception do banco de dados
        }
    }
    public User update(Long id,User user){
        User obj = userRepository.getById(id);
        updateUser(obj,user);
        return userRepository.save(userRepository.save(obj));
    }

    private void updateUser(User obj, User user) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
       
    }
}
