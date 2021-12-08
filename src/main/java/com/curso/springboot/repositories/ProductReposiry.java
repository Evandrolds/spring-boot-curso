
package com.curso.springboot.repositories;

import com.curso.springboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Evandro
 */
public interface ProductReposiry extends JpaRepository<Product, Long>{
    
}
