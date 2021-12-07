package com.curso.springboot.services;

import com.curso.springboot.entities.Category;
import com.curso.springboot.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Evandro
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryReposiroty;

    public List<Category> findAll() {
        return categoryReposiroty.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> or = categoryReposiroty.findById(id);
        return or.get();
    }

}
