package com.curso.springboot.resources;

import com.curso.springboot.entities.Product;
import com.curso.springboot.services.ProductService;
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
@RestController                     // aplicando um mapeamento 
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired                 // informando ao spring para fazer a INJEÇÃO DE DEPENDENCIA
    private ProductService productService;

    @GetMapping                //metodo que respondo a requissição do HTTP
    public ResponseEntity<List<Product>> findAll() {
        List<Product> pro = productService.findAll();
        return ResponseEntity.ok().body(pro);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product pro = productService.findById(id);
        return ResponseEntity.ok().body(pro);
    }

}
