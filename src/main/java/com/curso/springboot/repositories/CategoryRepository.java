
package com.curso.springboot.repositories;

import com.curso.springboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Evandro
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
