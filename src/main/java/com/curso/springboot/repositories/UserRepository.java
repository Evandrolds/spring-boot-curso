
package com.curso.springboot.repositories;

import com.curso.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Evandro
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
