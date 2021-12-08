package com.curso.springboot.services;

import com.curso.springboot.entities.Product;
import com.curso.springboot.repositories.ProductReposiry;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Evandro
 */
@Service
public class ProductService {

    @Autowired
    private ProductReposiry productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> pro = productRepository.findById(id);
        return pro.get();
    }
}
